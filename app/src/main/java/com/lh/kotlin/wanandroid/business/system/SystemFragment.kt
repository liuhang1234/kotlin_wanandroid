package com.lh.kotlin.wanandroid.business.system

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
import kotlinx.android.synthetic.main.fragment_system.*

/**
 * 体系
 */
class SystemFragment : BaseFragment(), SystemContract.View {


    private var systemPresenter: SystemContract.Presenter? = null
    private var mAdapter: SystemAdapter? = null

    private var mDatas = ArrayList<TreeListData.Children>()

    companion object {
        fun newInstance(): SystemFragment {
            var bundle = Bundle()
            var systemFragment = SystemFragment()
            systemFragment.arguments = bundle
            return systemFragment
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_system
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
        SystemPresenter(this)
        rv.layoutManager = LinearLayoutManager(mActivity, RecyclerView.VERTICAL, false)
        mAdapter = SystemAdapter(this, null)
        rv.adapter = mAdapter

        mAdapter?.onItemClickListener =
            BaseQuickAdapter.OnItemClickListener { adapter, view, position ->
                var treeListData = mAdapter!!.data[position] as TreeListData
//                var children = treeListData?.children?.get(0) as TreeListData.Children
                RouterManager.jumpToSystemViewPagerActivity(treeListData)

            }
        systemPresenter?.getTreeList()
    }

    override fun showTip(tip: String) {
    }

    override fun setPresenter(presenter: SystemContract.Presenter) {
        systemPresenter = presenter
    }

    override fun showData(datas: List<TreeListData>) {
        mAdapter?.setNewData(datas)
    }


    override fun showEmptyView() {
    }

    override fun onDestroyView() {
        super.onDestroyView()
        systemPresenter?.unsubscribe()
    }
}