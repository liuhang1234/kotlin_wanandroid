package com.lh.kotlin.wanandroid.business.system

import android.util.Log
import com.lh.kotlin.wanandroid.http.HttpResponseSubscriber
import com.lh.kotlin.wanandroid.http.HttpThrowable
import com.lh.kotlin.wanandroid.http.RetrofitUtils
import com.lh.kotlin.wanandroid.http.TransformUtils
import com.lh.kotlin.wanandroid.module.TreeListData
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Retrofit
import java.util.logging.Logger

/**
 * Created by SJD
 * time: 2019/6/24
 */
class SystemPresenter(var mView: SystemContract.View) : SystemContract.Presenter {
    private var mCompositeDisposable: CompositeDisposable? = null

    init {
        mView.setPresenter(this)
        mCompositeDisposable = CompositeDisposable()
    }

    override fun getTreeList() {
        RetrofitUtils.createService().getTreeList()
            .compose(TransformUtils.defaultSchedulers(mView))
            .subscribe(object :HttpResponseSubscriber<List<TreeListData>>(){
                override fun onSuccess(result: List<TreeListData>) {
                    if (null == result) {
                        return
                    }
                    mView.showData(result)
                }

                override fun onHttpError(e: HttpThrowable) {
                    Log.e("liuhang","e = "+e.message)
                }

            })
    }

    override fun unsubscribe() {
        mCompositeDisposable?.dispose()

    }
}