package com.lh.kotlin.wanandroid.business.systemlist

import android.os.Bundle
import android.view.View
import com.lh.kotlin.wanandroid.R
import com.lh.kotlin.wanandroid.base.BaseFragment
import com.lh.kotlin.wanandroid.module.Datas
import com.lh.kotlin.wanandroid.module.TreeListData

/**
 * Created by lh
 * time: 2019/6/24
 */
class SystemListFragment : BaseFragment(), SystemListContract.View {


    private val systemListPresenter: SystemListPresenter by lazy {
        SystemListPresenter(this)
    }
    private var cid: Int? = -1

    companion object {
        const val DATA = "data"
        fun newInstance(children: TreeListData.Children): SystemListFragment {
            var bundle = Bundle()
            var systemListFragment = SystemListFragment()
            bundle.putSerializable(DATA,children)
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
        systemListPresenter.getSystemList(cid,false)
    }

    override fun showTip(tip: String) {
    }

    override fun showData(datas: List<Datas>) {
    }

    override fun setPresenter(presenter: SystemListContract.Presenter) {
    }
}