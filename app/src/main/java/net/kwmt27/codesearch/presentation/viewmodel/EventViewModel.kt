package net.kwmt27.codesearch.presentation.viewmodel

import android.databinding.BaseObservable
import android.view.View

class EventViewModel(val name:String):BaseObservable(), ViewModel {
    override fun destroy() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun onClickEvent(view: View) {

    }
}