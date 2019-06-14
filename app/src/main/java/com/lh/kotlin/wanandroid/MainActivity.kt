package com.lh.kotlin.wanandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import butterknife.ButterKnife
import com.lh.kotlin.wanandroid.http.RetrofitUtils

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
