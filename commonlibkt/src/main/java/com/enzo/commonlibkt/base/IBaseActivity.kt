package com.enzo.commonlibkt.base

import android.os.Bundle

/**
 * 文 件 名: IBaseActivity
 * 创 建 人: xiaofy
 * 创建日期: 2019/12/28
 * 邮   箱: xiaofangyinwork@163.com
 */
interface IBaseActivity {

    fun getLayoutId(): Int

    fun initHeader()

    fun initView()

    fun initData(savedInstanceState: Bundle?)

    fun initListener()
}