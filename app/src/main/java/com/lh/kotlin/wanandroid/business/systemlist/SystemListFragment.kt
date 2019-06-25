package com.lh.kotlin.wanandroid.business.systemlist

import android.os.Bundle
import android.view.View
import com.lh.kotlin.wanandroid.R
import com.lh.kotlin.wanandroid.base.BaseFragment

/**
 * Created by lh
 * time: 2019/6/24
 */
class SystemListFragment:BaseFragment() {

    companion object {
        fun newInstance(bundle: Bundle): SystemListFragment {
            var systemListFragment = SystemListFragment()
            systemListFragment.arguments = bundle
            return systemListFragment
        }
    }


    override fun getLayoutId(): Int {
        return R.layout.fragment_system_list
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
    }
}