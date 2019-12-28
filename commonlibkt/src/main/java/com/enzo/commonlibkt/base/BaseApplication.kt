package com.enzo.commonlibkt.base

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex

/**
 * 文 件 名: BaseApplication
 * 创 建 人: xiaofangyin
 * 创建日期: 2017/11/28
 * 邮   箱: xiaofangyinwork@163.com
 */
open class BaseApplication : Application() {
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        var instance: BaseApplication? = null
            private set
    }
}