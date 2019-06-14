package com.lh.kotlin.wanandroid.utils

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

object ActivityUtils {
    fun addFragmenttoActivity(fragmentManager: FragmentManager,fragment: Fragment,layoutid:Int) {
        ActivityUtils.addFragmenttoActivity(fragmentManager,fragment,layoutid,null)
    }
    fun addFragmenttoActivity(fragmentManager: FragmentManager, fragment: Fragment, layoutid:Int, tag: String?) {
        if (fragment == null || fragmentManager == null) {
            return
        }
        var beginTransaction = fragmentManager.beginTransaction()
        beginTransaction.add(layoutid,fragment,tag)
        beginTransaction.commitNowAllowingStateLoss()
    }
}