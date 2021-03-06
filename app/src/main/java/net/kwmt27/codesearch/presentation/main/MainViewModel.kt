package net.kwmt27.codesearch.presentation.main

import android.databinding.BaseObservable
import android.util.Log
import android.view.View
import net.kwmt27.codesearch.application.di.ActivityScope
import javax.inject.Inject

/**
 * MainActivityで@Injectしているため、MainActivityのSubComponentが自動生成され、
 * MainActivityでinjectされるときに、MainViewModelのインスタンスが生成される。
 *
 * (例)
 *
 * MainActivityのinject時に下記が呼ばれ、
 * ```
 * MainActivity_MembersInjector.injectViewModel(instance, mainViewModelProvider.get());
 * ```
 * get()メソッドでMainViewModelのインスタンスを生成
 * ```
 * @Override
 * public MainViewModel get() {
 *   return new MainViewModel(navigatorProvider.get());
 * }
 * ```
 *
 */
@ActivityScope
class MainViewModel @Inject constructor() : BaseObservable() {

    fun onClickButton(view: View) {
        Log.d("MainViewModel", "onclick")
        //eventListNavigator.startActivityForResultSample()
    }
}
