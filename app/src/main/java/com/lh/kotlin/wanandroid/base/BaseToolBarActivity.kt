package com.lh.kotlin.wanandroid.base

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.Toolbar
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.appbar.AppBarLayout
import com.lh.kotlin.wanandroid.R
import com.lh.kotlin.wanandroid.utils.ActivityUtils

abstract class BaseToolBarActivity : BaseActivity(),View.OnClickListener {

    private var mAppBarLayout: AppBarLayout? = null
    private var mToolbar: Toolbar? = null
    private var mTitle: TextView? = null


    private var mLeftIv: ImageView? = null // 左图片
    private var mRightIv: ImageView? = null // 右图片
    private var mRightTv: TextView? = null // 右标题
    private var mRight2Iv: ImageView? = null // 右二图片（靠左的那个）

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutId())
        handleIntent(intent)
        addFragmentToActivity()
        init()
    }

    //初始化数据
    open fun init() {
        initToolBar()
    }

    private fun initToolBar() {
        mAppBarLayout = findViewById(R.id.app_bar_layout)
        mToolbar = findViewById(R.id.toolbar)
        mTitle = findViewById(R.id.title)
        mLeftIv = findViewById(R.id.left_iv)
        mRightIv = findViewById(R.id.right_iv)
        mRightTv = findViewById(R.id.right_tv)
        mRight2Iv = findViewById(R.id.right2_iv)

        if (mToolbar == null || mAppBarLayout == null) {
            throw IllegalStateException(
                "The BaseToolBarActivity must contain a toolbar."
            )
        }
        setSupportActionBar(mToolbar)
        val actionBar = supportActionBar
        actionBar?.setDisplayShowTitleEnabled(false)
        mToolbar?.setNavigationOnClickListener {   onBackPressed() }
        mToolbar?.setOnClickListener(this)

        showBackBtn(false)
        showLeftIv(false)
        showRightIv(false)
        showRightTv(false)
        setListener()
        showToolbar(false)
    }

    private fun setListener() {
        mLeftIv?.setOnClickListener(this)
        mRightIv?.setOnClickListener(this)
        mRight2Iv?.setOnClickListener(this)
        mRightTv?.setOnClickListener(this)
    }

    protected fun showRightTv(b: Boolean) {
    }

    protected fun showRightIv(b: Boolean) {
    }

    protected fun showLeftIv(b: Boolean) {
    }

    protected fun showToolbar(show: Boolean) {
        if (show) {
            mAppBarLayout?.setVisibility(View.VISIBLE)
            return
        }
        mAppBarLayout?.setVisibility(View.GONE)
    }
    override fun onClick(v: View?) {
    }
     abstract fun getFragment(): BaseFragment?
    // 添加fragment
     fun addFragmentToActivity() {
        var fragment: Fragment? = supportFragmentManager.findFragmentById(getFragmentContentId())
        if (fragment == null) {
            fragment = getFragment()
            if (fragment != null){
                ActivityUtils.addFragmenttoActivity(supportFragmentManager, fragment,getFragmentContentId())
            }
        }
    }

     abstract fun setLayoutId(): Int
     abstract fun getFragmentContentId(): Int
     fun handleIntent(intent: Intent) {

    }
    protected fun showBackBtn(show: Boolean) {
        val actionBar = supportActionBar ?: return
        // 设置是否显示返回键
        actionBar.setDisplayHomeAsUpEnabled(show)
    }
}