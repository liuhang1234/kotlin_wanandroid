package com.lh.kotlin.wanandroid.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trello.rxlifecycle2.components.support.RxFragment

abstract class BaseFragment : RxFragment() {
    protected var mActivity: BaseToolBarActivity? = null

    override fun onAttach(activity: Context) {
        super.onAttach(activity)
        if (activity is BaseToolBarActivity) {
            mActivity = activity
        }
    }




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(getLayoutId(), container, false)
        return view
    }

    //这个时候 view 才初始化完成 可以直接通过view的id 寻找控件
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view,savedInstanceState)
    }


    abstract fun getLayoutId():Int

    abstract fun initView(view :View, savedInstanceState: Bundle?)

    override fun onDestroy() {
        super.onDestroy()
    }
}