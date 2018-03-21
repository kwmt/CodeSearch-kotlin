package net.kwmt27.codesearch.presentation.repositorylist

import android.databinding.BaseObservable
import android.util.Log
import android.view.View
import net.kwmt27.codesearch.application.di.ActivityScope
import net.kwmt27.codesearch.domain.model.Event
import net.kwmt27.codesearch.domain.usecase.BaseObserver
import net.kwmt27.codesearch.domain.usecase.GetEvents
import net.kwmt27.codesearch.presentation.ViewModel
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named

/**
 * リポジトリ一覧に対応するViewModel
 */
@ActivityScope
class ReposFragmentViewModel @Inject constructor(private val getEvents: GetEvents) :
        BaseObservable(), ViewModel {
    @Inject
    @Named("ReposFragmentNavigator")
    lateinit var repossNavigator: ReposNavigator

    init {
        Timber.d("ReposFragmentViewModel is created.")
    }

    fun initialize(user: String, page: Int) {
        loadEvents(user, page)
    }

    override fun destroy() {
        this.getEvents.dispose()
    }

    private fun loadEvents(user: String, page: Int) {
        // TODO: Companionを書くしかないのかな...
        this.getEvents.execute(EventsObserver(), GetEvents.Companion.Params(user, page))
    }

    fun onClickButton(view: View) {
        Log.d("ReposFragmentViewModel", "onclick")
        repossNavigator.startMain2Activity(1)
    }

    inner class EventsObserver : BaseObserver<List<Event>>() {
        override fun onError(e: Throwable) {
            Timber.d("onError:" + e)
            e.printStackTrace()
        }

        override fun onSuccess(t: List<Event>) {
            Timber.d("onSuccess" + t)
            // TODO: render
        }
    }
}
