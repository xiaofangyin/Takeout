package com.enzo.takeout.ui.activity

import android.graphics.Color
import android.os.Bundle
import android.view.KeyEvent
import com.enzo.commonlib.base.BaseActivity
import com.enzo.commonlib.utils.common.ToastUtils
import com.enzo.commonlib.utils.statusbar.bar.StateAppBar
import com.enzo.commonlib.widget.tablayout.TabEntityConfig
import com.enzo.commonlib.widget.tablayout.TabLayout
import com.enzo.commonlib.widget.tablayout.TabView
import com.enzo.takeout.R

class MainActivity : BaseActivity() {

    private lateinit var tabLayout: TabLayout

    override fun getLayoutId(): Int {
        StateAppBar.setStatusBarLightMode(MainActivity@ this, Color.WHITE)
        return R.layout.activity_main
    }

    override fun initView() {
        tabLayout = findViewById(R.id.main_tab_layout)
        tabLayout.initData(TabEntityConfig.getEntities())
    }

    override fun initData(savedInstanceState: Bundle?) {
        tabLayout.currentItem = 0
    }

    override fun initListener() {
        tabLayout.setOnTabClickListener(object : TabLayout.OnTabClickListener {
            override fun onTabClick(view: TabView?, position: Int) {

            }

            override fun onTabReClick(view: TabView?, position: Int) {

            }
        })
    }

    private var firstTime: Long = 0 //点击两次退出应用计时

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            val secondTime = System.currentTimeMillis()
            if (secondTime - firstTime > 2000) {
                ToastUtils.showToast("再按一次退出程序")
                firstTime = System.currentTimeMillis()
                return true
            } else {
                System.exit(0)
            }
        }
        return super.onKeyDown(keyCode, event)
    }
}
