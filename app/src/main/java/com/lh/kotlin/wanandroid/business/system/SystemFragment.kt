package com.lh.kotlin.wanandroid.business.system

import android.os.Bundle
import android.view.View
import com.lh.kotlin.wanandroid.R
import com.lh.kotlin.wanandroid.base.BaseFragment

class SystemFragment:BaseFragment() {

    companion object {
        fun newInstance():SystemFragment  {
            var bundle = Bundle()
            var systemFragment = SystemFragment()
            systemFragment.arguments = bundle
            return systemFragment
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_system
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
    }
}