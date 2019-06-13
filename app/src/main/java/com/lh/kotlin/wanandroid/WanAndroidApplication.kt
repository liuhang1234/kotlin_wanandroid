package com.lh.kotlin.wanandroid

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

class WanAndroidApplication:Application() {
    override fun onCreate() {
        super.onCreate()

        initThirdPart()
    }

    private fun initThirdPart() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }
}