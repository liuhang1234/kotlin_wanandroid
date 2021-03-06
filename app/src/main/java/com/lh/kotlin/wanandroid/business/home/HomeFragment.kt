package com.lh.kotlin.wanandroid.business.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.launcher.ARouter
import com.chad.library.adapter.base.BaseQuickAdapter
import com.lh.kotlin.wanandroid.R
import com.lh.kotlin.wanandroid.base.BaseFragment
import com.lh.kotlin.wanandroid.business.detail.DetailActivity
import com.lh.kotlin.wanandroid.config.RouterManager
import com.lh.kotlin.wanandroid.module.Datas
import kotlinx.android.synthetic.main.list_view.*

class HomeFragment : BaseFragment(), HomeContract.View {


    private var homePresenter: HomeContract.Presenter ? = null

    private var mAdapter:HomeAdapter ? = null


    private var mDatas = ArrayList<Datas>()

    companion object {
        fun newInstance(): HomeFragment {
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
        HomePresenter(this)
        initData()
    }

    fun initData() {
        rv.layoutManager = LinearLayoutManager(mActivity,RecyclerView.VERTICAL,false)
        mAdapter =  HomeAdapter(this,null)
        rv.adapter = mAdapter

        mAdapter?.onItemClickListener =
            BaseQuickAdapter.OnItemClickListener { adapter, view, position ->
                var any = adapter?.data!![position] as Datas
                RouterManager.jumpToDetailActivity(any.link)
            }
        smartRefreshLayout.autoRefresh()
        smartRefreshLayout.setEnableRefresh(true)
        smartRefreshLayout.setEnableAutoLoadMore(true)
        smartRefreshLayout.setOnRefreshListener { queryData() }
        smartRefreshLayout.setOnLoadMoreListener { onLoadMoreRequested() }
    }

    private fun queryData() {
        homePresenter?.getHomeList(false)
    }

    private fun onLoadMoreRequested() {
        homePresenter?.getHomeList(true)
    }

    override fun showTip(tip: String?) {
    }

    override fun showData(datas: List<Datas>) {
        mAdapter?.setNewData(datas)
    }

    override fun setPresenter(presenter: HomeContract.Presenter) {
        homePresenter = presenter
    }

    override fun loadMoreFail() {
        smartRefreshLayout.finishLoadMoreWithNoMoreData()
    }

    override fun refreshComplete() {
        smartRefreshLayout.finishRefresh()
    }

    override fun loadMoreComplete() {
        smartRefreshLayout.finishLoadMore()
    }

    override fun loadMoreEnd() {
        smartRefreshLayout.finishLoadMoreWithNoMoreData()
    }
    override fun showEmptyView() {
    }

    override fun onDestroyView() {
        super.onDestroyView()
        homePresenter?.unsubscribe()
    }
}