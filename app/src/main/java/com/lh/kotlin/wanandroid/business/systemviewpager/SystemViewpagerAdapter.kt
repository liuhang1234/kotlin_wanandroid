package com.lh.kotlin.wanandroid.business.systemviewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.lh.kotlin.wanandroid.base.BaseFragment

/**
 * Created by lh
 * time: 2019/6/26
 */
class SystemViewpagerAdapter(fm:FragmentManager,
                             private val mFragments:List<BaseFragment>,
                             private val mTitles: List<String>)
    :FragmentPagerAdapter(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return mFragments[position]
    }

    override fun getCount(): Int {
       return mFragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mTitles[position]
    }
}