package com.lh.kotlin.wanandroid.business.my

import android.os.Bundle
import android.view.View
import com.lh.kotlin.wanandroid.R
import com.lh.kotlin.wanandroid.base.BaseFragment

class MyFragment:BaseFragment() {

    companion object {
        fun newInstance():MyFragment  {
            var bundle = Bundle()
            var myFragment = MyFragment()
            myFragment.arguments = bundle
            return myFragment
        }
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_my
    }
}