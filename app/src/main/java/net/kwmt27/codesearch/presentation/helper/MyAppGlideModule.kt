package net.kwmt27.codesearch.presentation.helper

import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule

/**
 * Glide v4 uses an annotation processor to generate an API that allows applications to access all options
 * in RequestBuilder, RequestOptions and any included integration libraries in a single fluent API.
 *
 * http://bumptech.github.io/glide/doc/generatedapi.html
 *
 * たとえば、centerCropはGlideにはないが、RequestBuilderが持っているcenterCropメソッドを次のようにメソッドチェーンで書くことができるようになる。
 *
 * ```
 * GlideApp
 * .with(imageView.context)
 * .load(imageUrl)
 * .centerCrop()
 * .placeholder(placeholderResId)
 * .into(imageView)
 * ```
 */
@GlideModule
class MyAppGlideModule : AppGlideModule()
