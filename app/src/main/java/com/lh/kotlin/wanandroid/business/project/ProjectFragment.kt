package com.lh.kotlin.wanandroid.business.project

import android.os.Bundle
import android.view.View
import com.lh.kotlin.wanandroid.R
import com.lh.kotlin.wanandroid.base.BaseFragment

class ProjectFragment:BaseFragment() {

    companion object {
        fun newInstance():ProjectFragment  {
            var bundle = Bundle()
            var projectFragment = ProjectFragment()
            projectFragment.arguments = bundle
            return projectFragment
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_project
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
    }
}