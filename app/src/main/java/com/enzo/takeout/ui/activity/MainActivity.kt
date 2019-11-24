package com.enzo.takeout.ui.activity

import android.graphics.Color
import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.enzo.commonlib.base.BaseActivity
import com.enzo.commonlib.utils.common.ToastUtils
import com.enzo.commonlib.utils.statusbar.bar.StateAppBar
import com.enzo.commonlib.widget.tablayout.TabEntityConfig
import com.enzo.commonlib.widget.tablayout.TabLayout
import com.enzo.commonlib.widget.tablayout.TabView
import com.enzo.takeout.R
import com.enzo.takeout.ui.fragment.HomeFragment1
import com.enzo.takeout.ui.fragment.HomeFragment2
import com.enzo.takeout.ui.fragment.HomeFragment3
import com.enzo.takeout.ui.fragment.HomeFragment4

class MainActivity : BaseActivity() {

    private lateinit var tabLayout: TabLayout
    private val mFragments: ArrayList<Fragment> = ArrayList()

    override fun getLayoutId(): Int {
        StateAppBar.setStatusBarLightMode(MainActivity@ this, Color.WHITE)
        return R.layout.activity_main
    }

    override fun initView() {
        tabLayout = findViewById(R.id.main_tab_layout)
        tabLayout.initData(TabEntityConfig.getEntities())
    }

    override fun initData(savedInstanceState: Bundle?) {
        mFragments.add(HomeFragment1())
        mFragments.add(HomeFragment2())
        mFragments.add(HomeFragment3())
        mFragments.add(HomeFragment4())
        switchFragment(0)
        tabLayout.currentItem = 0
    }

    override fun initListener() {
        tabLayout.setOnTabClickListener(object : TabLayout.OnTabClickListener {
            override fun onTabClick(view: TabView?, position: Int) {
                switchFragment(position)
            }

            override fun onTabReClick(view: TabView?, position: Int) {

            }
        })
    }

    private fun switchFragment(index: Int) {
        val fragmentManager = this.supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        hideFragment(transaction)
        showFragment(transaction, mFragments[index])
        transaction.commitAllowingStateLoss()
        fragmentManager.executePendingTransactions()
    }

    private fun showFragment(transaction: FragmentTransaction, fragment: Fragment) {
        if (fragment.isAdded) {
            transaction.show(fragment)
        } else {
            transaction.add(R.id.main_content, fragment, fragment.javaClass.simpleName)
        }
    }

    private fun hideFragment(transaction: FragmentTransaction) {
        for (i in mFragments.indices) {
            if (mFragments[i].isAdded) {
                transaction.hide(mFragments[i])
            }
        }
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
