package com.lh.kotlin.wanandroid


import com.lh.kotlin.wanandroid.base.BaseFragment
import com.lh.kotlin.wanandroid.base.BaseToolBarActivity
import com.lh.kotlin.wanandroid.business.MainFragment


class MainActivity : BaseToolBarActivity() {
    override fun getFragment(): BaseFragment? {
        return MainFragment.newInstance()
    }

    override fun setLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getFragmentContentId(): Int {
        return R.id.contentFrame
    }



    override fun init() {
        super.init()
        initTab()
        //测试一下
    }
    private fun initTab() {
    }
}
