package net.kwmt27.codesearch.presentation.eventlist

import android.databinding.BaseObservable
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
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

    val eventViewModelList: ObservableList<EventViewModel>

    init {
        Timber.d("EventListViewModel is created.")
        eventViewModelList = ObservableArrayList<EventViewModel>()
    }

    fun initialize(user: String, page: Int) {
        loadEvents(user, page)
    }

    override fun destroy() {
        this.fetchEventListUseCase.dispose()
    }

    private fun loadEvents(user: String, page: Int) {
        // TODO: Companionを書くしかないのかな...
        this.fetchEventListUseCase.execute(EventsObserver(), FetchEventListUseCase.Companion.Params(user, page))
    }

    inner class EventsObserver : BaseObserver<List<Event>>() {
        override fun onError(e: Throwable) {
            Timber.d("onError:" + e)
            e.printStackTrace()
        }

        override fun onSuccess(list: List<Event>) {
            Timber.d("onSuccess:$list")
            // TODO: render
            val eventViewModels = list.map {
                EventViewModel(it.githubUser, eventListNavigator).apply { }
            }
            render(eventViewModels)
        }
    }

    private fun render(list: List<EventViewModel>) {
        eventViewModelList.clear()
        eventViewModelList.addAll(list)
    }
}
