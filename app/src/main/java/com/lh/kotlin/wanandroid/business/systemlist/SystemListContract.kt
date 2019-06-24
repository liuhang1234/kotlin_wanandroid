package com.lh.kotlin.wanandroid.business.systemlist

import com.lh.kotlin.wanandroid.base.BasePresenter
import com.lh.kotlin.wanandroid.base.BaseView

/**
 * Created by SJD
 * time: 2019/6/24
 */
interface SystemListContract {

    interface View :BaseView<Presenter> {
        fun showTip(tip:String)

    }

    interface Presenter :BasePresenter{

    }
}