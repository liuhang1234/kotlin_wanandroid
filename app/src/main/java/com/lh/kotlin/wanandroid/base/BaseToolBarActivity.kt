package com.lh.kotlin.wanandroid.base

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.appbar.AppBarLayout
import com.lh.kotlin.wanandroid.R
import com.lh.kotlin.wanandroid.utils.ActivityUtils

abstract class BaseToolBarActivity : BaseActivity(),View.OnClickListener {

    protected var mAppBarLayout: AppBarLayout? = null
    protected var mToolbar: Toolbar? = null
    private var mTitle: TextView? = null
    private var toolbarBottomLine: View? = null


    private var mLeftIv: ImageView? = null // 左图片
    private var mRightIv: ImageView? = null // 右图片
    protected var mRightTv: TextView? = null // 右标题
    private var mRight2Iv: ImageView? = null // 右二图片（靠左的那个）

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(setLayoutId())
        handleIntent(intent)
        addFragmentToActivity()
        init()
    }

    //初始化数据
    protected fun init() {
        initToolBar()
    }

    private fun initToolBar() {
        mAppBarLayout = findViewById(R.id.app_bar_layout) as AppBarLayout?
        mToolbar = findViewById(R.id.toolbar) as Toolbar?
        mTitle = findViewById(R.id.title) as TextView?
        mLeftIv = findViewById(R.id.left_iv) as ImageView?
        mRightIv = findViewById(R.id.right_iv) as ImageView?
        mRightTv = findViewById(R.id.right_tv) as TextView?
        mRight2Iv = findViewById(R.id.right2_iv) as ImageView?

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


    override fun onClick(v: View?) {
    }
    protected abstract fun getFragment(): BaseFragment?
    // 添加fragment
    protected fun addFragmentToActivity() {
        var fragment: Fragment? = supportFragmentManager.findFragmentById(getFragmentContentId())
        if (fragment == null) {
            fragment = getFragment()
            if (fragment != null){
                ActivityUtils.addFragmenttoActivity(supportFragmentManager, fragment,getFragmentContentId())
            }
        }
    }

    protected abstract fun setLayoutId(): Int
    protected abstract fun getFragmentContentId(): Int
    protected fun handleIntent(intent: Intent) {

    }
    protected fun showBackBtn(show: Boolean) {
        val actionBar = supportActionBar ?: return
        // 设置是否显示返回键
        actionBar.setDisplayHomeAsUpEnabled(show)
    }
}