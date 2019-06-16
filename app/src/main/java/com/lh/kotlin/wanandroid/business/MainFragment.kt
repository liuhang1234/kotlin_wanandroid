package com.lh.kotlin.wanandroid.business

import android.os.Bundle
import android.view.View
import com.lh.kotlin.wanandroid.R
import com.lh.kotlin.wanandroid.base.BaseFragment

class MainFragment: BaseFragment() {

    companion object {
        fun newInstance():MainFragment  {
            var bundle = Bundle()
            var mainFragment = MainFragment()
            mainFragment.arguments = bundle
            return mainFragment
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_main
    }

    override fun initView(view: View?, savedInstanceState: Bundle?) {
    }
}