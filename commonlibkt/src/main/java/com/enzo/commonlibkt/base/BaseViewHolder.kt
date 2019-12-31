package com.enzo.commonlibkt.base

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

/**
 * 文 件 名: BaseViewHolder
 * 创 建 人: xiaofangyin
 * 创建日期: 2018/5/26
 * 邮   箱: xiaofangyinwork@163.com
 */
abstract class BaseViewHolder<T>(itemView: View?) : ViewHolder(itemView!!) {

    val context: Context
        get() = itemView.context

    fun findView(resId: Int): View {
        return itemView.findViewById(resId)
    }

    abstract fun setUpView(model: T, position: Int, adapter: RecyclerView.Adapter<*>?)
}