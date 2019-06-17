package com.lh.kotlin.wanandroid.business.home

import com.lh.kotlin.wanandroid.http.RetrofitUtils
import com.lh.kotlin.wanandroid.module.Datas
import io.reactivex.disposables.CompositeDisposable

class HomePresenter(var mView:HomeContract.View):HomeContract.Presenter {
    private var mList: ArrayList<Datas>?=null
    private var mCompositeDisposable: CompositeDisposable?=null

    private var page = 0
    init {
        mView.setPresenter(this)
        mCompositeDisposable = CompositeDisposable()
    }
    override fun getHomeList(index: Int, loadMore: Boolean) {

    }

    override fun unsubscribe() {
        mCompositeDisposable!!.dispose()
    }
}