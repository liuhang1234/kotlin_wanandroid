package com.lh.kotlin.wanandroid.config

import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter
import com.lh.kotlin.wanandroid.business.detail.DetailActivity

/**
 * Created by lh
 * time: 2019/6/24
 */
class RouterManager {
    companion object{
        fun jumpToDetailActivity(url:String) {
            var bundle = Bundle()
            bundle.putString(DetailActivity.URL,url)
            ARouter.getInstance().build(Consts.DETAIL_ACTIVITY)
                .with(bundle).navigation()
        }
    }
}