package com.lh.kotlin.wanandroid.business.system

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lh.kotlin.wanandroid.R
import com.lh.kotlin.wanandroid.base.BaseFragment
import com.lh.kotlin.wanandroid.module.Datas
import com.lh.kotlin.wanandroid.module.TreeListData
import kotlinx.android.synthetic.main.fragment_system.*

/**
 * 体系
 */
class SystemFragment:BaseFragment(),SystemContract.View {


    private val systemPresenter :SystemPresenter by lazy {
        SystemPresenter(this)
    }
    private val mAdapter:SystemAdapter by lazy{
        SystemAdapter(this,null)
    }
    private val linearLayoutManager : LinearLayoutManager by lazy {
        LinearLayoutManager(mActivity, RecyclerView.VERTICAL,false)
    }

    private var mDatas = ArrayList<TreeListData.Children>()

    companion object {
        fun newInstance():SystemFragment  {
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
        rv.run {
            layoutManager = linearLayoutManager
            adapter = mAdapter
        }
        systemPresenter.getTreeList()
    }
    override fun showTip(tip: String) {
    }

    override fun setPresenter(presenter: SystemContract.Presenter) {
    }

    override fun showData(datas: List<TreeListData>) {
        mAdapter.setNewData(datas)
    }


    override fun showEmptyView() {
    }
    override fun onDestroyView() {
        super.onDestroyView()
        systemPresenter.unsubscribe()
    }
}