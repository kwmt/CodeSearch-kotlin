package net.kwmt27.codesearch.presentation.repositorylist

import android.databinding.BaseObservable
import net.kwmt27.codesearch.application.di.ActivityScope
import net.kwmt27.codesearch.domain.model.Event
import net.kwmt27.codesearch.domain.usecase.BaseObserver
import net.kwmt27.codesearch.domain.usecase.FetchEventListUseCase
import net.kwmt27.codesearch.presentation.ViewModel
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named

/**
 * リポジトリ一覧に対応するViewModel
 */
@ActivityScope
class RepositoryListViewModel @Inject constructor(private val fetchEventListUseCase: FetchEventListUseCase) :
        BaseObservable(), ViewModel {
    @Inject
    @Named("ReposFragmentNavigator")
    lateinit var repositoryListNavigator: RepositoryListNavigator

    init {
        Timber.d("RepositoryListViewModel is created.")
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
            Timber.d("onError:$e")
            e.printStackTrace()
        }

        override fun onSuccess(t: List<Event>) {
            Timber.d("onSuccess:$t")
            // TODO: render
        }
    }
}
