package com.lh.kotlin.wanandroid.business

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.lh.kotlin.wanandroid.R
import com.lh.kotlin.wanandroid.base.BaseFragment
import com.lh.kotlin.wanandroid.business.home.HomeFragment
import com.lh.kotlin.wanandroid.business.my.MyFragment
import com.lh.kotlin.wanandroid.business.project.ProjectFragment
import com.lh.kotlin.wanandroid.business.system.SystemFragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment() {
    private val mFragments =ArrayList<BaseFragment>()
    private var mainAdapter: MainAdapter? = null
    companion object {
        fun newInstance(): MainFragment {
            var bundle = Bundle()
            var mainFragment = MainFragment()
            mainFragment.arguments = bundle
            return mainFragment
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_main
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
        initData()
    }

    private fun initData() {

        mFragments.add(HomeFragment.newInstance())
        mFragments.add(SystemFragment.newInstance())
        mFragments.add(ProjectFragment.newInstance())
        mFragments.add(MyFragment.newInstance())

        mainAdapter = fragmentManager?.let { MainAdapter(it,mFragments) }
        bottom_navigation_view.setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                var itemId = item.itemId
                when(itemId) {
                    R.id.home -> {
                        viewpager.currentItem = 0
                    }
                    R.id.system -> {
                        viewpager.currentItem = 1
                    }
                    R.id.project -> {
                        viewpager.currentItem = 2
                    }
                    R.id.my -> {
                        viewpager.currentItem = 3
                    }
                }
                return false
            }

        })
//        viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
//            override fun onPageSelected(position: Int) {
//                super.onPageSelected(position)
//                bottom_navigation_view.selectedItemId = position
//            }
//        })
        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                bottom_navigation_view.menu.getItem(position).isChecked = true
            }

        })
        viewpager.adapter = mainAdapter

    }
//    private var onNavigationItemSelectedListener = object : BottomNavigationView.OnNavigationItemSelectedListener {
//        override fun onNavigationItemSelected(item: MenuItem): Boolean {
//            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//        }
//
//    }
}