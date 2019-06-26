package com.lh.kotlin.wanandroid.business.systemlist

import android.util.Log
import com.lh.kotlin.wanandroid.http.*
import com.lh.kotlin.wanandroid.module.Datas
import com.lh.kotlin.wanandroid.module.HomeListData
import com.lh.kotlin.wanandroid.module.TreeListData
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by lh
 * time: 2019/6/24
 */
class SystemListPresenter(var mView:SystemListContract.View): SystemListContract.Presenter{

    private val mDatas= mutableListOf<HomeListData>()

    private var mCompositeDisposable: CompositeDisposable? = null
    private var page = 0
    init {
        mView.setPresenter(this)
        mCompositeDisposable = CompositeDisposable()
    }

    override fun getSystemList(cid: Int?, loadMore: Boolean) {
        if (!loadMore) {
            page = 0
        }
        RetrofitUtils.createService().getSystemList(page++,cid)
            .compose(TransformUtils.defaultSchedulers(mView))
            .subscribe(object : HttpResponseSubscriber<HomeListData>(){
                override fun onSuccess(result: HomeListData) {
                    Log.e("liuhang","result = "+result.size)
                }

                override fun onHttpError(e: HttpThrowable) {
                    Log.e("liuhang","onHttpError = "+e.message)

                }

            })
    }
    override fun unsubscribe() {
        mCompositeDisposable?.dispose()
    }
}