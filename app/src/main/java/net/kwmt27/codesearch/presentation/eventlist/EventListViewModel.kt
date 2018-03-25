package net.kwmt27.codesearch.presentation.eventlist

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.android.databinding.library.baseAdapters.BR
import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.processors.PublishProcessor
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.SingleSubject
import net.kwmt27.codesearch.application.di.ActivityScope
import net.kwmt27.codesearch.domain.usecase.FetchEventListUseCase
import net.kwmt27.codesearch.presentation.common.ViewModel
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

    /** リストの状態をリセットするフラグ */
    @get:Bindable
    var resetLoadingState: Boolean = false
        set(resetLoadingState) {
            field = resetLoadingState
            notifyPropertyChanged(BR.resetLoadingState)
        }

    var hasMore = BehaviorRelay.createDefault(false)

    val eventViewModelList = BehaviorSubject
            .createDefault<List<EventViewModel>>(arrayListOf())

    var currentPage: Int = 0

    private lateinit var paginator: PublishProcessor<Int>

    fun initialize(user: String) {
        currentPage = 1
        paginator = PublishProcessor.create()
        paginator.onBackpressureDrop()
                .filter { !hasMore.value }
                .doOnNext { hasMore.accept(true) }
                .concatMap { loadEvents(user, it).toFlowable() }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    hasMore.accept(false)
                    eventViewModelList.onNext(it)
                    currentPage++
                }, {
                    hasMore.accept(false)
                })
        onLoadMore(currentPage)
    }

    fun onLoadMore(page: Int) {
        paginator.onNext(page)
    }

    override fun destroy() {
//        this.fetchEventListUseCase.dispose()
    }

    private fun loadEvents(user: String, page: Int): Single<List<EventViewModel>> {
        return this.fetchEventListUseCase.execute(user, page).flatMap {
            val eventViewModels = it.map {
                return@map EventViewModel(it.githubUser).also { eventViewModel ->
                    eventViewModel.eventListNavigator = this.eventListNavigator
                }
            }
            SingleSubject.just(eventViewModels)
        }
    }
}
