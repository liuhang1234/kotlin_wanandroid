package com.lh.kotlin.wanandroid.business.home

import com.lh.kotlin.wanandroid.base.BasePresenter
import com.lh.kotlin.wanandroid.base.BaseView
import com.lh.kotlin.wanandroid.module.Datas
import com.lh.kotlin.wanandroid.module.HomeListData

interface HomeContract {

    interface View :BaseView<Presenter> {
        fun showTip(tip:String?)

        fun showData(datas: List<Datas>)

        fun loadMoreFail()

        fun refreshComplete()

        fun loadMoreComplete()

        fun loadMoreEnd()

        fun showEmptyView()
    }

    interface Presenter :BasePresenter{

        fun getHomeList(loadMore:Boolean)
    }
}