package net.kwmt27.codesearch.presentation.viewmodel

import android.content.Intent
import android.databinding.BaseObservable
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import android.util.Log
import android.view.View
import net.kwmt27.codesearch.domain.interactor.BaseObserver
import net.kwmt27.codesearch.domain.interactor.GetEvents
import net.kwmt27.codesearch.domain.model.EventModel
import net.kwmt27.codesearch.di.ActivityScope
import net.kwmt27.codesearch.presentation.navigator.Navigator
import timber.log.Timber
import javax.inject.Inject

/**
 * イベント一覧に対応するViewModel
 */
@ActivityScope
class EventsViewModel @Inject constructor(private val getEvents: GetEvents, val navigator:Navigator) : BaseObservable(), ViewModel {

    private  val REQUET_CODE = 1

//    @Inject
//    lateinit var navigator:Navigator

    val eventViewModels:ObservableList<EventViewModel>

    init {
        Timber.d("EventsViewModel is created.")
        eventViewModels = ObservableArrayList<EventViewModel>()

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
        Log.d("EventsViewModel", "onclick")
        //loadEvents("kwmt", 1)
//        navigator.startActivityEventsFragmentToMain2Activity()
        navigator.startMain2Activity(REQUET_CODE)
    }


    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Timber.d("requestCode:" + requestCode + ", resultCode:" +  resultCode +", data:" + data)
    }

    inner class EventsObserver : BaseObserver<List<EventModel>>() {
        override fun onError(e: Throwable) {
            Timber.d("onError:" + e)
            e.printStackTrace()
        }

        override fun onSuccess(list: List<EventModel>) {
            Timber.d("onSuccess" + list)
            // TODO: render
            val eventViewModels = list.map {
                EventViewModel(it.githubUser).apply {  }
            }
            render(eventViewModels)
        }

    }

    private fun render(list:List<EventViewModel>) {
        eventViewModels.clear()
        eventViewModels.addAll(list)
    }


}
