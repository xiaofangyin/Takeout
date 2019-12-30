package com.enzo.commonlibkt.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * 文 件 名: BaseActivity
 * 创 建 人: xiaofy
 * 创建日期: 2019/12/28
 * 邮   箱: xiaofangyinwork@163.com
 */
abstract  class BaseActivity : AppCompatActivity(),IBaseActivity {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layoutId = getLayoutId()
        if(layoutId != 0){
            setContentView(layoutId)
        }
        initView()
        initData(savedInstanceState)
        initListener()
    }
}