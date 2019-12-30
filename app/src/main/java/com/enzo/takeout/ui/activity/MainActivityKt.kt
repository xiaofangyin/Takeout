package com.enzo.takeout.ui.activity

import android.os.Bundle
import android.view.KeyEvent
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.enzo.commonlibkt.base.BaseActivity
import com.enzo.commonlibkt.widget.tablayout.TabEntityConfig
import com.enzo.commonlibkt.widget.tablayout.TabLayout
import com.enzo.commonlibkt.widget.tablayout.TabView
import com.enzo.takeout.R
import com.enzo.takeout.ui.fragment.HomeFragment1
import com.enzo.takeout.ui.fragment.HomeFragment2
import com.enzo.takeout.ui.fragment.HomeFragment3
import com.enzo.takeout.ui.fragment.HomeFragment4
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 文 件 名: MainActivityKt
 * 创 建 人: xiaofy
 * 创建日期: 2019/12/28
 * 邮   箱: xiaofangyinwork@163.com
 */
class MainActivityKt : BaseActivity() {

    private val mFragments: ArrayList<Fragment> = ArrayList()

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        main_tab_layout.initData(TabEntityConfig.entities)
    }

    override fun initData(savedInstanceState: Bundle?) {
        mFragments.add(HomeFragment1())
        mFragments.add(HomeFragment2())
        mFragments.add(HomeFragment3())
        mFragments.add(HomeFragment4())
        switchFragment(0)
        main_tab_layout.currentItem = 0
    }

    override fun initListener() {
        main_tab_layout.setOnTabClickListener(object : TabLayout.OnTabClickListener {
            override fun onTabClick(view: TabView, position: Int) {
                switchFragment(position)
            }

            override fun onTabReClick(view: TabView, position: Int) {

            }
        })
    }

    private fun switchFragment(index: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        hideFragment(transaction)
        showFragment(transaction, mFragments[index])
        transaction.commitAllowingStateLoss()
        supportFragmentManager.executePendingTransactions()
    }

    private fun showFragment(transaction: FragmentTransaction, fragment: Fragment) {
        if (fragment.isAdded) {
            transaction.show(fragment)
        } else {
            transaction.add(R.id.main_content, fragment)
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
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show()
                firstTime = System.currentTimeMillis()
                return true
            } else {
                finish()
            }
        }
        return super.onKeyDown(keyCode, event)
    }
}