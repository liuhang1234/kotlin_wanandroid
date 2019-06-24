package com.lh.kotlin.wanandroid.business.detail

import com.alibaba.android.arouter.facade.annotation.Route
import com.lh.kotlin.wanandroid.R
import com.lh.kotlin.wanandroid.base.BaseActivity
import com.lh.kotlin.wanandroid.base.BaseFragment
import com.lh.kotlin.wanandroid.base.BaseToolBarActivity
import com.lh.kotlin.wanandroid.config.Consts

@Route(path = Consts.DETAIL_ACTIVITY)
class DetailActivity :BaseToolBarActivity(){
    companion object {
        val URL = "URL"
        val BUNDLE = "bundle"
    }
    override fun getFragment(): BaseFragment? {
        var newInstance = DetailFragment.newInstance(intent.extras)
        return newInstance
    }

    override fun setLayoutId(): Int {
        return R.layout.activity_detail
    }

    override fun getFragmentContentId(): Int {
        return R.id.contentFrame
    }
}