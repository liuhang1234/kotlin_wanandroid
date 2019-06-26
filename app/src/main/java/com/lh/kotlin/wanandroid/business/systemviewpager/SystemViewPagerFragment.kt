package com.lh.kotlin.wanandroid.business.systemviewpager

import android.os.Bundle
import android.view.View
import com.lh.kotlin.wanandroid.R
import com.lh.kotlin.wanandroid.base.BaseFragment
import com.lh.kotlin.wanandroid.business.systemlist.SystemListFragment
import com.lh.kotlin.wanandroid.module.TreeListData
import kotlinx.android.synthetic.main.fragment_system_view_pager.*

/**
 * Created by lh
 * time: 2019/6/26
 */
class SystemViewPagerFragment :BaseFragment() {

    private val mFragments =ArrayList<BaseFragment>()
    private val mTitles = ArrayList<String>()
    private val mSystemViewpagerAdapter : SystemViewpagerAdapter by lazy {
        SystemViewpagerAdapter(fragmentManager!!,mTitles = mTitles,mFragments = mFragments)
    }
    companion object{
        fun newInstance(bundle: Bundle): SystemViewPagerFragment {
            var systemViewPagerFragment = SystemViewPagerFragment()
            systemViewPagerFragment.arguments = bundle
            return systemViewPagerFragment
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_system_view_pager
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {

        var treeListData: TreeListData = arguments?.getSerializable(SystemViewpagerActivity.DATA) as TreeListData ?: return
        var children = treeListData.children

        for(i in children!!.indices) {
            var children1 = children[i]
            mTitles.add(children1.name)
            mFragments.add(SystemListFragment.newInstance(children1))
        }

        viewpager.run {
            adapter = mSystemViewpagerAdapter
        }
        tab.setupWithViewPager(viewpager)
    }
}