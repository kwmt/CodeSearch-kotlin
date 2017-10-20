package net.kwmt27.codesearch.presentation.viewmodel

import android.databinding.BaseObservable
import android.util.Log
import android.view.View
import net.kwmt27.codesearch.presentation.internal.di.ActivityScope
import net.kwmt27.codesearch.presentation.navigator.Navigator
import javax.inject.Inject

@ActivityScope
class MainViewModel @Inject
constructor(val navigator: Navigator) : BaseObservable() {

    fun onClickButton(view: View) {
        Log.d("MainViewModel", "onclick")
    }

}