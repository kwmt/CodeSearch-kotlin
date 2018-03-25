package net.kwmt27.codesearch.presentation.common.binding

import android.databinding.BindingAdapter
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import net.kwmt27.codesearch.presentation.common.recyclerview.InfiniteRecyclerViewOnScrollListener

// RecyclerView関連のBindingAdapter

/**
 * 無限スクロール対応のリスナーをセットする
 * @param recyclerView RecyclerView
 * @param resetLoadingState 無限スクロールのリセット
 * @param onScrolledListener [InfiniteRecyclerViewOnScrollListener.OnScrolledListener]
 */
@BindingAdapter(value = ["resetLoadingState", "onLoadMore"], requireAll = false)
fun RecyclerView.setRecyclerViewScrollCallback(
    resetLoadingState: Boolean,
    onScrolledListener: InfiniteRecyclerViewOnScrollListener.OnScrolledListener
) {
    clearOnScrollListeners()
    addOnScrollListener(InfiniteRecyclerViewOnScrollListener(resetLoadingState, onScrolledListener))
}

/**
 * 引っ張って更新(SwipeRefreshLayout)の引っ張った時のリスナーセットする
 * @param swipeRefreshLayout swipeRefreshLayout
 * @param onRefresh 引っ張って更新したときのリスナー
 */
@BindingAdapter(value = ["onPulledToRefresh"])
fun SwipeRefreshLayout.setOnSwipeRefreshListener(onPulledToRefresh: Runnable) {
    setOnRefreshListener { onPulledToRefresh.run() }
}
