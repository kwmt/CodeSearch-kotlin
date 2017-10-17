package net.kwmt27.codesearch.presentation.viewmodel

import android.databinding.BaseObservable
import android.util.Log
import android.view.View
import net.kwmt27.codesearch.presentation.internal.di.FragmentScope
import javax.inject.Inject


@FragmentScope
class MainFragmentViewModel @Inject constructor() : BaseObservable() {

    fun onClickButton(view: View) {
        Log.d("MainFragmentViewModel", "onclick")
    }

}