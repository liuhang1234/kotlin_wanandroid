package com.lh.kotlin.wanandroid.business.home

import android.os.Bundle
import android.view.View
import com.lh.kotlin.wanandroid.R
import com.lh.kotlin.wanandroid.base.BaseFragment
import com.lh.kotlin.wanandroid.module.HomeListData

class HomeFragment:BaseFragment() ,HomeContract.View{


    private var homePresenter : HomePresenter? =null

    companion object {
        fun newInstance():HomeFragment  {
            var bundle = Bundle()
            var homeFragment = HomeFragment()
            homeFragment.arguments = bundle
            return homeFragment
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
        initPresenter()
    }

    private fun initPresenter() {
        homePresenter = HomePresenter(this)
        homePresenter?.getHomeList(1, loadMore = true)
    }

    override fun showTip(tip: String) {
    }

    override fun showData(data: HomeListData) {
    }

    override fun setPresenter(presenter: HomeContract.Presenter) {
    }
}