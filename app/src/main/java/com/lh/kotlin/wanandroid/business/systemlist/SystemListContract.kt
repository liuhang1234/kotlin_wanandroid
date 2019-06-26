package com.lh.kotlin.wanandroid.business.systemlist

import com.lh.kotlin.wanandroid.base.BasePresenter
import com.lh.kotlin.wanandroid.base.BaseView
import com.lh.kotlin.wanandroid.module.Datas

/**
 * Created by lh
 * time: 2019/6/24
 */
interface SystemListContract {

    interface View :BaseView<Presenter> {
        fun showTip(tip:String)

        fun showData(datas: List<Datas>)

        fun loadMoreFail()

        fun refreshComplete()

        fun loadMoreComplete()

        fun loadMoreEnd()

        fun showEmptyView()
    }

    interface Presenter :BasePresenter{
        fun getSystemList(cid: Int?,loadMore:Boolean)
    }
}