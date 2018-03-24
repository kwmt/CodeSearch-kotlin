package net.kwmt27.codesearch.presentation.eventlist

import android.databinding.BaseObservable
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.processors.PublishProcessor
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.SingleSubject
import net.kwmt27.codesearch.application.di.ActivityScope
import net.kwmt27.codesearch.domain.model.Event
import net.kwmt27.codesearch.domain.usecase.BaseObserver
import net.kwmt27.codesearch.domain.usecase.FetchEventListUseCase
import net.kwmt27.codesearch.presentation.common.ViewModel
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named

/**
 * イベント一覧に対応するViewModel
 */
@ActivityScope
class EventListViewModel @Inject constructor(
    private val fetchEventListUseCase: FetchEventListUseCase
) : BaseObservable(), ViewModel {

    @Inject
    @Named("EventsFragmentNavigator")
    lateinit var eventListNavigator: EventListNavigator

    val eventViewModelList: ObservableList<IEventViewModel>

    var hasMore = BehaviorRelay.createDefault(false)

    val eventViewModelListSubject = BehaviorSubject
            .createDefault<List<EventViewModel>>(arrayListOf())

    init {
        Timber.d("EventListViewModel is created.")
        eventViewModelList = ObservableArrayList<IEventViewModel>()
    }

    private var currentPage: Int = 0

    private lateinit var paginator: PublishProcessor<Int>

    fun initialize(user: String, page: Int) {
        currentPage = 1
        paginator = PublishProcessor.create()
        paginator.onBackpressureDrop()
                .filter { !hasMore.value }
                .doOnNext { hasMore.accept(true) }
                .concatMap { loadEvents("kwmt", it).toFlowable() }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    hasMore.accept(false)
                    currentPage++
                    eventViewModelListSubject.onNext(it)
                }, {
                    hasMore.accept(false)

                })
        loadEvents(user, page)
    }

    override fun destroy() {
//        this.fetchEventListUseCase.dispose()
    }

    private fun loadEvents(user: String, page: Int): Single<List<EventViewModel>> {
        return this.fetchEventListUseCase.execute(user, page).flatMap {
            val eventViewModels = it.map {
                return@map EventViewModel(it.githubUser)
            }
            SingleSubject.just(eventViewModels)
        }
    }

    inner class EventsObserver : BaseObserver<List<Event>>() {
        override fun onError(e: Throwable) {
            Timber.d("onError:$e")
            e.printStackTrace()
        }

        override fun onSuccess(list: List<Event>) {
            Timber.d("onSuccess:$list")
            // TODO: render
            val eventViewModels = list.map {
                EventViewModel(it.githubUser).apply { }
            }
            render(eventViewModels)
        }
    }

    private fun render(list: List<EventViewModel>) {
        eventViewModelList.clear()
        eventViewModelList.addAll(list)
    }
}
