package com.lh.kotlin.wanandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import butterknife.ButterKnife
import com.lh.kotlin.wanandroid.base.BaseFragment
import com.lh.kotlin.wanandroid.base.BaseToolBarActivity
import com.lh.kotlin.wanandroid.http.RetrofitUtils

class MainActivity : BaseToolBarActivity() {
    override fun getFragment(): BaseFragment? {
        return null
    }

    override fun setLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getFragmentContentId(): Int {
        return R.id.contentFrame
    }


}
