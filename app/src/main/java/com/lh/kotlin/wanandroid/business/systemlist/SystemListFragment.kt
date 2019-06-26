package com.lh.kotlin.wanandroid.business.systemlist

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.lh.kotlin.wanandroid.R
import com.lh.kotlin.wanandroid.base.BaseFragment
import com.lh.kotlin.wanandroid.config.RouterManager
import com.lh.kotlin.wanandroid.module.Datas
import com.lh.kotlin.wanandroid.module.TreeListData
import kotlinx.android.synthetic.main.list_view.*

/**
 * Created by lh
 * time: 2019/6/24
 */
class SystemListFragment : BaseFragment(), SystemListContract.View {

    private var mAdapter: SystemListAdapter? = null;

    private val systemListPresenter: SystemListPresenter by lazy {
        SystemListPresenter(this)
    }

    private val linearLayoutManager: LinearLayoutManager? = null
    private var cid: Int? = -1

    companion object {
        const val DATA = "data"
        fun newInstance(children: TreeListData.Children): SystemListFragment {
            var bundle = Bundle()
            var systemListFragment = SystemListFragment()
            bundle.putSerializable(DATA, children)
            systemListFragment.arguments = bundle
            return systemListFragment
        }
    }


    override fun getLayoutId(): Int {
        return R.layout.fragment_system_list
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
        var serializable = arguments?.getSerializable(SystemListActivity.DATA) as TreeListData.Children
        cid = serializable.id
        initData()
    }

    fun initData() {
        rv.layoutManager = LinearLayoutManager(mActivity, RecyclerView.VERTICAL, false)
        mAdapter = SystemListAdapter(this, null)
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
        systemListPresenter.getSystemList(cid, false)
    }

    private fun onLoadMoreRequested() {
        systemListPresenter.getSystemList(cid, true)

    }

    override fun showTip(tip: String) {
    }

    override fun showData(datas: List<Datas>) {
        mAdapter?.setNewData(datas)
    }

    override fun setPresenter(presenter: SystemListContract.Presenter) {
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
}