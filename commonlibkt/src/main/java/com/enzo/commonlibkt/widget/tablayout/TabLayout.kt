package com.enzo.commonlibkt.widget.tablayout

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import java.util.*

/**
 * 文 件 名: TabLayout
 * 创 建 人: xiaofangyin
 * 创建日期: 2017/4/1
 * 邮   箱: xiaofangyinwork@163.com
 */
class TabLayout @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr), ITabLayout,
    View.OnClickListener {
    private var mLastPosition = -1
    private val mTabList: MutableList<TabView>

    init {
        orientation = HORIZONTAL
        mTabList = ArrayList()
    }

    override fun initData(list: List<TabEntity>) {
        for (i in list.indices) {
            val tab = TabView(context)
            tab.initTab(list[i])
            tab.setOnClickListener(this)
            tab.tag = i
            val layoutParams = LayoutParams(0, LayoutParams.MATCH_PARENT)
            layoutParams.weight = 1f
            tab.layoutParams = layoutParams
            addView(tab)
            mTabList.add(tab)
        }
    }

    override fun onClick(v: View) {
        val position = v.tag as Int
        if (position != mLastPosition) {
            currentItem = position
            if (mListener != null) {
                mListener!!.onTabClick(mTabList[position], position)
            }
        } else {
            if (mListener != null) {
                mListener!!.onTabReClick(mTabList[position], position)
            }
        }
    }

    override var currentItem: Int
        get() = mLastPosition
        set(currentItem) {
            if (mLastPosition >= 0 && mLastPosition < mTabList.size) {
                mTabList[mLastPosition].isSelected = false
            }
            if (currentItem >= 0 && currentItem < mTabList.size) {
                mTabList[currentItem].isSelected = true
                mLastPosition = currentItem
            }
        }

    override fun addMessageNum(position: Int, messageNum: Int) {
        if (position >= 0 && position < mTabList.size) {
            mTabList[position].addMessageNumber(messageNum)
        }
    }

    override fun setMessageNum(position: Int, messageNum: Int) {
        if (position >= 0 && position < mTabList.size) {
            mTabList[position].messageNumber = messageNum
        }
    }

    override fun resetMessageNum(position: Int) {
        if (position >= 0 && position < mTabList.size) {
            mTabList[position].resetMessageNumber()
        }
    }

    override fun getMessageNum(position: Int): Int {
        return if (position >= 0 && position < mTabList.size) {
            mTabList[position].messageNumber
        } else {
            0
        }
    }

    override fun showRedPoint(position: Int) {
        if (position >= 0 && position < mTabList.size) {
            mTabList[position].showRedPoint(true)
        }
    }

    override fun hideRedPoint(position: Int) {
        if (position >= 0 && position < mTabList.size) {
            mTabList[position].showRedPoint(false)
        }
    }

    private var mListener: OnTabClickListener? = null

    fun setOnTabClickListener(listener: OnTabClickListener) {
        mListener = listener
    }

    interface OnTabClickListener {
        fun onTabClick(view: TabView, position: Int)

        fun onTabReClick(view: TabView, position: Int)
    }
}