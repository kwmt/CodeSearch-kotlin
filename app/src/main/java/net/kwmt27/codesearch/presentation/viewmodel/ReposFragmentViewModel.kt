package net.kwmt27.codesearch.presentation.viewmodel

import android.databinding.BaseObservable
import android.util.Log
import android.view.View
import net.kwmt27.codesearch.domain.interactor.BaseObserver
import net.kwmt27.codesearch.domain.interactor.GetEvents
import net.kwmt27.codesearch.domain.model.EventModel
import net.kwmt27.codesearch.presentation.internal.di.ActivityScope
import timber.log.Timber
import javax.inject.Inject

@ActivityScope
class ReposFragmentViewModel @Inject constructor(private val getEvents: GetEvents) : BaseObservable(), ViewModel {

    init {
        Timber.d("ReposFragmentViewModel is created.")
    }





    fun initialize(user:String, page:Int) {
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
        loadEvents("kwmt", 1)
    }


    inner class EventsObserver : BaseObserver<List<EventModel>>() {
        override fun onError(e: Throwable) {
            Timber.d("onError:" + e)
            e.printStackTrace()
        }

        override fun onSuccess(t: List<EventModel>) {
            Timber.d("onSuccess" + t)
            // TODO: render
        }

    }


}