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
    private var mList: ArrayList<Datas>?=null
    private var mCompositeDisposable: CompositeDisposable?=null

    private var page = 0
    init {
        mView.setPresenter(this)
        mCompositeDisposable = CompositeDisposable()
    }
    override fun getHomeList(index: Int, loadMore: Boolean) {
        RetrofitUtils.createService().getHomeList(index)
            .compose(TransformUtils.defaultSchedulers(mView))
            .subscribe(object : HttpResponseSubscriber<HomeListData>(){
                override fun onSuccess(result: HomeListData) {
                    Log.e("liuhang","onSuccess"+result.pageCount)
                }

                override fun onHttpError(e: HttpThrowable) {
                    Log.e("liuhang","onHttpError "+e.message)

                }

            })
    }

    override fun unsubscribe() {
        mCompositeDisposable!!.dispose()
    }
}