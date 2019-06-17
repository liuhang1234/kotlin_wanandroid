package com.lh.kotlin.wanandroid.business.home

import com.lh.kotlin.wanandroid.base.BasePresenter
import com.lh.kotlin.wanandroid.base.BaseView
import com.lh.kotlin.wanandroid.module.HomeListData

interface HomeContract {

    interface View :BaseView<Presenter> {
        fun showTip(tip:String)

        fun showData(data:HomeListData)
    }

    interface Presenter :BasePresenter{

        fun getHomeList(index :Int,loadMore:Boolean)
    }
}