package com.lh.kotlin.wanandroid.business.systemlist

import com.alibaba.android.arouter.facade.annotation.Route
import com.lh.kotlin.wanandroid.R
import com.lh.kotlin.wanandroid.base.BaseFragment
import com.lh.kotlin.wanandroid.base.BaseToolBarActivity
import com.lh.kotlin.wanandroid.config.Consts

/**
 * Created by lh
 * time: 2019/6/24
 */
@Route(path = Consts.SYSTEM_LIST_ACTIVITY)
class SystemListActivity:BaseToolBarActivity() {

    companion object{
        val DATA = "data"
    }
    override fun getFragment(): BaseFragment? {
        return SystemListFragment.newInstance(intent.extras)
    }

    override fun setLayoutId(): Int {
        return R.layout.activity_system_list
    }

    override fun getFragmentContentId(): Int {
        return R.id.contentFrame
    }
}