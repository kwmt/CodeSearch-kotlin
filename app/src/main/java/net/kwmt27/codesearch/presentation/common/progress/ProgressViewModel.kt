package net.kwmt27.codesearch.presentation.common.progress

import android.databinding.ObservableBoolean
import net.kwmt27.codesearch.application.di.ActivityScope
import javax.inject.Inject

/**
 * [ProgressView]に対応するViewModel
 */
@ActivityScope
class ProgressViewModel @Inject constructor() {

    /** プログレス表示するか */
    var showProgress: ObservableBoolean = ObservableBoolean(false)

    /**
     * プログレスを表示する
     */
    fun show() {
        showProgress.set(true)
    }

    /**
     * プログレスを閉じる
     */
    fun dismiss() {
        showProgress.set(false)
    }

    /**
     * プログレスが表示中か
     * @return true:表示中
     */
    fun isShowing() = showProgress.get()
}