package com.lh.kotlin.wanandroid.business.system

import com.lh.kotlin.wanandroid.base.BasePresenter
import com.lh.kotlin.wanandroid.base.BaseView
import com.lh.kotlin.wanandroid.module.Datas
import com.lh.kotlin.wanandroid.module.TreeListData

/**
 * Created by SJD
 * time: 2019/6/24
 */
interface SystemContract {

    interface View : BaseView<Presenter> {
        fun showTip(tip:String)

        fun showData(datas: List<TreeListData>)

        fun showEmptyView()
    }

    interface Presenter :BasePresenter{
        fun getTreeList()
    }
}