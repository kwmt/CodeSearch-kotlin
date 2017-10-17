package net.kwmt27.codesearch.presentation.viewmodel

import android.databinding.BaseObservable
import android.util.Log
import android.view.View
import net.kwmt27.codesearch.presentation.internal.di.ActivityScope
import javax.inject.Inject


@ActivityScope
class MainFragmentViewModel @Inject constructor() : BaseObservable() {

    fun onClickButton(view: View) {
        Log.d("MainFragmentViewModel", "onclick")
    }

}