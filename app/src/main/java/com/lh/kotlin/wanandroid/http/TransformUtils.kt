package com.lh.kotlin.wanandroid.http

import com.lh.kotlin.wanandroid.base.BaseFragment
import com.lh.kotlin.wanandroid.base.BaseView
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class TransformUtils {
    companion object {
        fun <T>defaultSchedulers():ObservableTransformer<T,T>{
            return ObservableTransformer { tObservable -> tObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()) }
        }
        fun <T> defaultSchedulers(baseView: BaseView<*>?): ObservableTransformer<T,T> {
            if(null != baseView && baseView is BaseFragment) {
                return ObservableTransformer {
                    tObservable -> tObservable.subscribeOn(Schedulers.io())
                    .subscribeOn(AndroidSchedulers.mainThread())
                    .compose((baseView as BaseFragment).bindToLifecycle())
                }
            }
            return ObservableTransformer { tObservable -> tObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()) }

        }
    }
}