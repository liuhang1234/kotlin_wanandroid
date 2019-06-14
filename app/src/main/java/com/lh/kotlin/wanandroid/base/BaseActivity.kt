package com.lh.kotlin.wanandroid.base

import android.app.Activity
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.os.PersistableBundle
import com.lh.kotlin.wanandroid.utils.ActivityManagerPool
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import org.greenrobot.eventbus.EventBus
import java.lang.ref.WeakReference

abstract class BaseActivity : RxAppCompatActivity() {
    private var weakRefActivity: WeakReference<Activity>? = null
    protected var activity: Activity? = null
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        weakRefActivity = WeakReference(this)
        ActivityManagerPool.getActivityManage().add(weakRefActivity)
        EventBus.getDefault().register(this)

    }

    override fun onDestroy() {
        super.onDestroy()
        activity = null
        ActivityManagerPool.getActivityManage().remove(weakRefActivity)
        EventBus.getDefault().unregister(this)
    }

    override fun getResources(): Resources {
        var res = super.getResources()
        var configuration = Configuration()
        configuration.setToDefaults()
        res.updateConfiguration(configuration,res.displayMetrics)
        return res
    }
}