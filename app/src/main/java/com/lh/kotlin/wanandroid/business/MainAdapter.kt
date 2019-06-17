package com.lh.kotlin.wanandroid.business

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.lh.kotlin.wanandroid.base.BaseFragment

class MainAdapter(fm: FragmentManager, private val mFragments: List<BaseFragment>): FragmentPagerAdapter(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return mFragments[position]
    }

    override fun getCount(): Int {
        return mFragments.size
    }
}