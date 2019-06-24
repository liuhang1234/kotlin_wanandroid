package com.lh.kotlin.wanandroid.business.systemlist

import io.reactivex.disposables.CompositeDisposable

/**
 * Created by SJD
 * time: 2019/6/24
 */
class SystemListPresenter(var mView:SystemListContract.View): SystemListContract.Presenter{
    private var mCompositeDisposable: CompositeDisposable? = null

    init {
        mView.setPresenter(this)
        mCompositeDisposable = CompositeDisposable()
    }

    override fun unsubscribe() {
    }
}