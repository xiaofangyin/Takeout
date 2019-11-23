package com.enzo.takeout.ui.activity

import android.os.Bundle
import com.enzo.commonlib.base.BaseActivity
import com.enzo.commonlib.widget.tablayout.TabEntityConfig
import com.enzo.commonlib.widget.tablayout.TabLayout
import com.enzo.commonlib.widget.tablayout.TabView
import com.enzo.takeout.R

class MainActivity : BaseActivity() {

    private lateinit var tabLayout: TabLayout

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        tabLayout = findViewById(R.id.main_tab_layout)
        tabLayout.initData(TabEntityConfig.getEntities())
    }

    override fun initData(savedInstanceState: Bundle?) {

    }

    override fun initListener() {
        tabLayout.setOnTabClickListener(object : TabLayout.OnTabClickListener {
            override fun onTabClick(view: TabView?, position: Int) {

            }

            override fun onTabReClick(view: TabView?, position: Int) {

            }
        })
    }
}
