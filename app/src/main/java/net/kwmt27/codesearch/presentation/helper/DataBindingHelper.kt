package net.kwmt27.codesearch.presentation.helper

import android.databinding.BindingAdapter
import android.support.v4.content.ContextCompat
import android.text.TextUtils
import android.widget.ImageView
import net.kwmt27.codesearch.R


object DataBindingHelper {
    @JvmStatic
    @BindingAdapter("imageUrl")
    fun setImageUrl(imageView: ImageView, imageUrl: String) {
        setImageUrl(imageView, imageUrl, R.color.grey200)
    }

    private fun setImageUrl(imageView: ImageView, imageUrl: String, placeholderResId: Int) {
        if (TextUtils.isEmpty(imageUrl)) {
            imageView.setImageDrawable(
                    ContextCompat.getDrawable(imageView.context, placeholderResId));
        } else {
            GlideApp
                    .with(imageView.context)
                    .load(imageUrl)
                    .centerCrop()
                    .placeholder(placeholderResId)
                    .into(imageView)
        }
    }


}
