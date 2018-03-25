package net.kwmt27.codesearch.presentation.common.progress

import android.content.Context
import android.databinding.DataBindingUtil
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import net.kwmt27.codesearch.R
import net.kwmt27.codesearch.databinding.ViewProgressBinding

/**
 * プログレスView
 */
class ProgressView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private val binding: ViewProgressBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
            R.layout.view_progress, this, true)

    private val viewModel = ProgressViewModel()

    init {
        binding.viewModel = viewModel
    }

    /**
     * プログレスを表示する
     */
    fun show() {
        viewModel.show()
    }

    /**
     * プログレスを閉じる
     */
    fun dismiss() {
        viewModel.dismiss()
    }

    /**
     * プログレスが表示中か
     * @return true:表示中
     */
    fun isShowing() = viewModel.isShowing()
}