package com.lh.kotlin.wanandroid.business.home

import android.util.Log
import com.lh.kotlin.wanandroid.http.HttpResponseSubscriber
import com.lh.kotlin.wanandroid.http.HttpThrowable
import com.lh.kotlin.wanandroid.http.RetrofitUtils
import com.lh.kotlin.wanandroid.http.TransformUtils
import com.lh.kotlin.wanandroid.module.Datas
import com.lh.kotlin.wanandroid.module.HomeListData
import io.reactivex.disposables.CompositeDisposable

class HomePresenter(var mView:HomeContract.View):HomeContract.Presenter {
    private val mDatas= mutableListOf<Datas>()

    private var mCompositeDisposable: CompositeDisposable? = null

    private var page = 0
    init {
        mView.setPresenter(this)
        mCompositeDisposable = CompositeDisposable()
    }
    override fun getHomeList( loadMore: Boolean) {
        if (!loadMore) {
            page = 0
        }
        RetrofitUtils.createService().getHomeList(page++)
            .compose(TransformUtils.defaultSchedulers(mView))
            .subscribe(object : HttpResponseSubscriber<HomeListData>(){
                override fun onSuccess(result: HomeListData) {
                    if (result == null) {
                        mView.loadMoreFail()
                        mView.refreshComplete()
                        mView.showEmptyView()
                        mView.loadMoreEnd()
                        return
                    }
                    if (!loadMore) {
                        mDatas.clear()
                    }
                    if (result.over) {
                        mView.loadMoreEnd()
                    }else{
                        mView.loadMoreComplete()
                    }
                    if (loadMore) {
                        mView.loadMoreComplete()
                    } else{
                        mView.refreshComplete()
                    }
                    mDatas.addAll(result.datas!!)
                    Log.e("liuhang","mDatas = "+mDatas.size)
                    mView.showData(mDatas)

                }

                override fun onHttpError(e: HttpThrowable) {
                    page--
                    mView.showTip(e.message)
                    mView.loadMoreFail()
                    mView.refreshComplete()
                    mView.showEmptyView()
                }

            })
    }

    override fun unsubscribe() {
        mCompositeDisposable?.dispose()
    }
}