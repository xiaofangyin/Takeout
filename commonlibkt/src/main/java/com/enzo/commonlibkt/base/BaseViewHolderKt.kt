package com.enzo.commonlibkt.base

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * 文 件 名: BaseViewHolderKt
 * 创 建 人: xiaofangyin
 * 创建日期: 2019-12-31
 * 邮   箱: xiaofangyin@360.cn
 */
abstract class BaseViewHolderKt<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val context: Context
        get() = itemView.context

    fun findView(resId: Int): View {
        return itemView.findViewById(resId)
    }

    abstract fun setUpView(
        model: T,
        position: Int,
        adapter: RecyclerView.Adapter<BaseViewHolderKt<T>>
    )
}