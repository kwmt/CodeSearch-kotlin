package net.kwmt27.codesearch.presentation.view.adapter


import android.content.Context
import android.support.v7.widget.RecyclerView


abstract class BaseRecyclerAdapter<T,VH : RecyclerView.ViewHolder>(
        val context:Context,  val list:List<T>) : RecyclerView.Adapter<VH>() {

//    private var list: MutableList<U> = ArrayList()



//    override fun getItemViewType(position: Int): Int {
//        if (position == HEADER_POSITION) {
//            return ItemType.Ad.typeId
//        }
//        return if (entities[position - HEADER_SIZE] === ItemType.Progress) {
//            ItemType.Progress.typeId
//        } else ItemType.Normal.typeId
//    }


    override fun getItemCount(): Int {
//        return if (list.size > 0) list.size + HEADER_SIZE else 0
        return list.size
    }

    fun getItem(position:Int):T {
        return list.get(position)
    }


//    fun addProgressItemTypeThenNotify(entity: U) {
//        entity.setItemType(ItemType.Progress)
//        entities.add(entity)
//        val pos = entities.size - 1
//        if (pos > -1) {
//            notifyItemInserted(pos)
//        }
//    }
//
//    fun removeProgressItemTypeThenNotify() {
//        val pos = findPositionByItemType(ItemType.Progress)
//        if (pos > -1) {
//            entities.removeAt(pos)
//            notifyItemRemoved(pos)
//        }
//    }
//
//
//    private fun findPositionByItemType(type: ItemType): Int {
//        for (i in entities.indices) {
//            if (entities[i].getItemType() === type) {
//                return i
//            }
//        }
//        return -1
//    }

    companion object {

        val HEADER_POSITION = 0
        val HEADER_SIZE = 1
    }

}