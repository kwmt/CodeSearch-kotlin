package net.kwmt27.codesearch.presentation.common.progress

/**
 * プログレスバーの表示・非表示可能インターフェイス(Progressableは`progress` + `able`の造語)
 */
interface Progressable {
    /** プログレスリスナー */
    var progressListener: ProgressListener?

    /**
     * 表示する
     */
    fun show() = progressListener?.show()

    /**
     *  閉じる
     */
    fun dismiss() = progressListener?.dismiss()

    /**
     * プログレスバーが表示中か。
     */
    fun isShowing() = progressListener?.isShowing() ?: false
}