package com.enzo.takeout.ui.activity

import android.os.Bundle
import com.enzo.commonlibkt.base.BaseActivity
import com.enzo.commonlibkt.widget.tablayout.TabEntityConfig
import com.enzo.commonlibkt.widget.tablayout.TabLayout
import com.enzo.commonlibkt.widget.tablayout.TabView
import com.enzo.takeout.R
import kotlinx.android.synthetic.main.activity_main2.*

/**
 * 文 件 名: MainActivityKt
 * 创 建 人: xiaofy
 * 创建日期: 2019/12/28
 * 邮   箱: xiaofangyinwork@163.com
 */
class MainActivityKt : BaseActivity() {

    override fun getLayoutId(): Int = R.layout.activity_main2

    override fun initHeader() {
    }

    override fun initView() {
        main_tab_layout.initData(TabEntityConfig.entities)
    }

    override fun initData(savedInstanceState: Bundle?) {
    }

    override fun initListener() {
        main_tab_layout.setOnTabClickListener(object : TabLayout.OnTabClickListener {
            override fun onTabClick(view: TabView?, position: Int) {

            }

            override fun onTabReClick(view: TabView?, position: Int) {

            }
        })
    }
}