package com.enzo.commonlibkt.widget.tablayout

/**
 * 文 件 名: ITabLayout
 * 创 建 人: xiaofangyin
 * 创建日期: 2017/12/17
 * 邮   箱: xiaofangyinwork@163.com
 */
interface ITabLayout {
    fun initData(list: List<TabEntity>)
    var currentItem: Int
    fun addMessageNum(position: Int, messageNum: Int)
    fun setMessageNum(position: Int, messageNum: Int)
    fun resetMessageNum(position: Int)
    fun getMessageNum(position: Int): Int
    fun showRedPoint(position: Int)
    fun hideRedPoint(position: Int)
}