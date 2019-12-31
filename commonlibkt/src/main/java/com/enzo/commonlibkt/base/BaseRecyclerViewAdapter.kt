package com.enzo.commonlibkt.base

import androidx.recyclerview.widget.RecyclerView
import java.util.*

/**
 * 文 件 名: BaseRecyclerViewAdapter
 * 创 建 人: xiaofangyin
 * 创建日期: 2018/5/26
 * 邮   箱: xiaofangyinwork@163.com
 */
abstract class BaseRecyclerViewAdapter<T> :
    RecyclerView.Adapter<BaseViewHolder<*>?>() {

    private var mData: MutableList<T> = ArrayList()
    var onItemclickListener: OnItemclickListener? = null

    fun setOnItemClickListener(listener: OnItemclickListener?) {
        onItemclickListener = listener
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    val data: List<T>
        get() = mData

    fun setNewData(list: List<T>?) {
        mData.clear()
        if (list != null) {
            mData.addAll(list)
            notifyDataSetChanged()
        }
    }

    fun setLoadMoreData(list: List<T>?) {
        if (list != null) {
            val size = mData.size
            mData.addAll(list)
            notifyItemInserted(size)
            notifyItemRangeChanged(size, mData.size - size)
        }
    }

    interface OnItemclickListener {
        fun onItemClick(position: Int)
    }
}