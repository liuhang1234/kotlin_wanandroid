package com.lh.kotlin.wanandroid.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

object ActivityUtils {
    fun addFragmenttoActivity(fragmentManager: FragmentManager, fragment: Fragment, layoutid:Int) {
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