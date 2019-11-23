package com.enzo.takeout.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.enzo.commonlib.base.BaseActivity
import com.enzo.commonlib.utils.statusbar.StatusBarUtils

/**
 * 文 件 名: WelcomeActivity
 * 创 建 人: xiaofy
 * 创建日期: 2019/11/23
 * 邮   箱: xiaofangyinwork@163.com
 */
class WelcomeActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return 0
    }

    override fun initView() {

    }

    override fun initData(savedInstanceState: Bundle?) {
        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            val intent = Intent(WelcomeActivity@ this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }

    override fun initListener() {

    }

}