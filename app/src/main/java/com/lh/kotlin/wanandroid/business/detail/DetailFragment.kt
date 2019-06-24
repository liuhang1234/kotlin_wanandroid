package com.lh.kotlin.wanandroid.business.detail

import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import com.lh.kotlin.wanandroid.R
import com.lh.kotlin.wanandroid.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment:BaseFragment() {


    companion object {
        fun newInstance(bundle: Bundle): DetailFragment {
            var homeFragment = DetailFragment()
            homeFragment.arguments = bundle
            return homeFragment
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_detail

    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
        var url = arguments?.getString(DetailActivity.URL)

        webview.loadUrl(url)
        webview.settings.javaScriptEnabled = true
        webview.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
        webview.settings.setAppCacheEnabled(true)
        webview.settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
    }
}