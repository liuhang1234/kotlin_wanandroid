package com.lh.kotlin.wanandroid.business.systemlist

import com.lh.kotlin.wanandroid.http.BaseResponse
import com.lh.kotlin.wanandroid.http.RetrofitUtils
import com.lh.kotlin.wanandroid.http.TransformUtils
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by lh
 * time: 2019/6/24
 */
class SystemListPresenter(var mView:SystemListContract.View): SystemListContract.Presenter{


    private var mCompositeDisposable: CompositeDisposable? = null
    private var page = 0
    init {
        mView.setPresenter(this)
        mCompositeDisposable = CompositeDisposable()
    }

    override fun getSystemList(cid: Int, loadMore: Boolean) {
        if (!loadMore) {
            page = 0
        }
//        RetrofitUtils.createService().getSystemList(page,cid)
//            .compose(TransformUtils.defaultSchedulers(mView))
//            .subscribe(object :BaseResponse<>)
    }
    override fun unsubscribe() {
        mCompositeDisposable?.dispose()
    }
}