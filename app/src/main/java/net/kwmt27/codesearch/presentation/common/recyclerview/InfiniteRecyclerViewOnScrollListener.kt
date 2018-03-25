package net.kwmt27.codesearch.presentation.common.recyclerview

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

/**
 * 無限スクロール対応のOnScrollListener
 */
class InfiniteRecyclerViewOnScrollListener(
    resetLoadingState: Boolean,
    private val onScrollListener: OnScrolledListener
) : RecyclerView.OnScrollListener() {

    /** データロード中ならtrue */
    private var isLoading = true
    /** 最後にロードしたデータの合計個数 */
    private var previousTotalItemCount = 0
    /** 現在のページ */
    private var currentPage = 0

    companion object {
        /**
         * リストの一番下に見えているitemが、
         * リストの合計数からVISIBLE_THRESHOLD個手前のitemの場合に、読み込みを開始する
         */
        private const val VISIBLE_THRESHOLD = 5
        private const val START_PAGE_INDEX = 0
    }

    init {
        if (resetLoadingState) {
            resetState()
        }
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val totalItemCount = recyclerView.layoutManager.itemCount

        // 合計アイテム数がゼロで前の値がゼロである場合、
        // リストは無効であると仮定し、初期状態に戻します。
        if (totalItemCount < previousTotalItemCount) {
            currentPage = START_PAGE_INDEX
            previousTotalItemCount = totalItemCount
            if (totalItemCount == 0) {
                isLoading = true
            }
        }

        // ロード中で、データが変更したか確認し、変更されていたら,
        // ロードを終了し、現在のページ数と合計個数を更新する。
        if (isLoading && totalItemCount > previousTotalItemCount) {
            isLoading = false
            previousTotalItemCount = totalItemCount
        }

        // ロード中ではなく、見えてるItem数＋ある閾値がデータ個数以上ならロード要求を出す
        if (!isLoading && canLoadMoreItems(recyclerView.layoutManager)) {
            currentPage++
            onScrollListener.onLoadMore(currentPage)
            isLoading = true
        }
    }

    private fun resetState() {
        currentPage = START_PAGE_INDEX
        previousTotalItemCount = 0
        isLoading = true
    }

    interface OnScrolledListener {
        /**
         * スクロール中に、読み込みを開始する
         * @param page 読み込むページ番号
         */
        fun onLoadMore(page: Int)
    }

    /**
     * 読み込み可能かどうか
     */
    private fun canLoadMoreItems(layoutManager: RecyclerView.LayoutManager): Boolean {
        val visibleItemCount = layoutManager.childCount
        val totalItemCount = layoutManager.itemCount
        val firstVisibleItemPosition = when (layoutManager) {
            is LinearLayoutManager -> layoutManager.findFirstVisibleItemPosition()
            else -> throw IllegalArgumentException("LinearLayoutManagerのみサポートしています。")
        }
        return firstVisibleItemPosition + visibleItemCount + VISIBLE_THRESHOLD >= totalItemCount
    }
}