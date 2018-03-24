package net.kwmt27.codesearch.presentation.common.recyclerview

import android.support.v7.widget.RecyclerView

/**
 * 共通RecyclerViewのAdapter
 *
 * リストに複数のViewTypeがある場合にも使えます。
 */
abstract class SimpleRecyclerAdapter<T>(
        val list: MutableList<T>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return list.size
    }

    /**
     * 全てのリストを追加して通知する
     */
    fun addAll(list: List<T>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    /**
     * リストを追加して通知する
     */
    fun add(viewModel: T) {
        list.add(viewModel)
        notifyItemInserted(list.size - 1)
    }

    /**
     * リストを削除して通知する
     */
    fun remove(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(list.size)
    }

    /**
     * リストをクリアして通知する
     */
    fun clear() {
        list.clear()
        notifyDataSetChanged()
    }

    /**
     * 指定したpositionのItemを取得する
     */
    fun getItem(position: Int): T {
        return list[position]
    }
}