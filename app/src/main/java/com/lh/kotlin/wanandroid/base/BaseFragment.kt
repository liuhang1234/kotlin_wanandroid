package com.lh.kotlin.wanandroid.base

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.Unbinder
import com.trello.rxlifecycle2.components.support.RxFragment

abstract class BaseFragment : RxFragment() {
    protected var mActivity: BaseToolBarActivity? = null

    protected var unbinder : Unbinder?=null
    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        if (activity is BaseToolBarActivity) {
            mActivity = activity
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

//    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        var view = inflater?.inflate(getLayoutId(), container, false) as View
//        initView(view,savedInstanceState)
//        unbinder = ButterKnife.bind(this, view)
//        return view
//    }

    abstract fun getLayoutId():Int

    abstract fun initView(view :View?, savedInstanceState: Bundle?)

    override fun onDestroy() {
        super.onDestroy()
        unbinder?.unbind()
    }
}