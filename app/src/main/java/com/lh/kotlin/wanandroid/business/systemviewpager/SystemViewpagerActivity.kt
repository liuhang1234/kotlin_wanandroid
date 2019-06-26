package com.lh.kotlin.wanandroid.business.systemviewpager

import com.alibaba.android.arouter.facade.annotation.Route
import com.lh.kotlin.wanandroid.R
import com.lh.kotlin.wanandroid.base.BaseFragment
import com.lh.kotlin.wanandroid.base.BaseToolBarActivity
import com.lh.kotlin.wanandroid.config.Consts

/**
 * Created by lh
 * time: 2019/6/26
 */
@Route(path = Consts.SYSTEM_VIEWPAGER_ACTIVITY)
class SystemViewpagerActivity:BaseToolBarActivity() {
    companion object{
        const val DATA = "data"
    }
    override fun getFragment(): BaseFragment? {
        return SystemViewPagerFragment.newInstance(intent.extras)
    }

    override fun setLayoutId(): Int {
        return R.layout.activity_system_viewpager
    }

    override fun getFragmentContentId(): Int {
        return R.id.contentFrame
    }
}