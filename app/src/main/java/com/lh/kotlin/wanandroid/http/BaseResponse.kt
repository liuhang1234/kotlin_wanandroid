package com.lh.kotlin.wanandroid.http

class BaseResponse<T> {
    /**
     * 1：成功，0：失败 ，2：无数据
     */
    var errorCode: Int = 0

    var errorMsg: String? = null

    var data: T? = null

    companion object {
        val FAILE = 0
        val SUCCESS = 1
    }
}