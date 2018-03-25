package net.kwmt27.codesearch.presentation.common.progress

/**
 * プログレスリスナー
 */
interface ProgressListener {
    /**
     * 表示する
     */
    fun show()

    /**
     *  閉じる
     */
    fun dismiss()

    /**
     * 表示中かどうか。
     * @return true:表示中
     */
    fun isShowing(): Boolean
}