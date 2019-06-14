package com.lh.kotlin.wanandroid.utils

import android.app.Activity
import java.lang.ref.WeakReference
import java.util.ArrayList

class ActivityManagerPool {



    private val activityList = ArrayList<WeakReference<Activity>?>()
    // java 中的static方法
    companion object {
        private var activityManagerPool: ActivityManagerPool? = null

        fun getActivityManage(): ActivityManagerPool{
            if (null == activityManagerPool) {
                activityManagerPool = ActivityManagerPool()
            }
            return activityManagerPool as ActivityManagerPool
        }
    }


    fun add(weakRefActivity: WeakReference<Activity>?) {
        activityList.add(weakRefActivity)
    }

    fun remove(weakRefActivity: WeakReference<Activity>?) {
        activityList.remove(weakRefActivity)
    }

    fun finishAll() {
        if (activityList.isNotEmpty()) {
            for (activityWeakReference in activityList) {
                val activity = activityWeakReference?.get()
                if (activity != null && !activity.isFinishing) {
                    activity.finish()
                }
            }
            activityList.clear()
        }
    }

}