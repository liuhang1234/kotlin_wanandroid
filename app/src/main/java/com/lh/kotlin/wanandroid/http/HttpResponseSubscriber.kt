package com.lh.kotlin.wanandroid.http

import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import org.apache.http.conn.ConnectTimeoutException
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

abstract class HttpResponseSubscriber<T> :Observer<BaseResponse<T>> {

    //对应HTTP的状态码
    companion object {
         val UNAUTHORIZED = 401
         val FORBIDDEN = 403
         val NOT_FOUND = 404
         val REQUEST_TIMEOUT = 408
         val INTERNAL_SERVER_ERROR = 500
         val BAD_GATEWAY = 502
         val SERVICE_UNAVAILABLE = 503
         val GATEWAY_TIMEOUT = 504
    }

    override fun onSubscribe(d: Disposable) {
    }

    override fun onNext(response: BaseResponse<T>) {
        if (null == response) {
            onHttpError(HttpThrowable("http请求无返回结果"))
        }
        onSuccess(response.data!!)
    }


    override fun onError(e: Throwable) {
        e.printStackTrace()
        var throwable = HttpThrowable()
        // 在这里做全局的错误处理
        if (e is ConnectException || e is UnknownHostException ||
            e is SocketTimeoutException || e is ConnectTimeoutException
        ) {
            throwable = HttpThrowable("网络不给力,请检查网络连接")
        } else if (e is HttpException) {
            when (e.code()) {
                UNAUTHORIZED//未经授权的
                    , FORBIDDEN //权限错误，需要实现
                    , NOT_FOUND, REQUEST_TIMEOUT, GATEWAY_TIMEOUT//网关超时
                    , INTERNAL_SERVER_ERROR//内部服务器错误
                    , BAD_GATEWAY//网关
                    , SERVICE_UNAVAILABLE//服务不可用
                -> throwable = HttpThrowable(e.code(), "网络不给力,请检查网络连接")
                else//均视为网络错误
                -> throwable = HttpThrowable(e.code(), "网络不给力,请检查网络连接")
            }
        }
        onHttpError(throwable)

    }

    override fun onComplete() {

    }
    abstract fun onSuccess(result: T)


    abstract fun onHttpError(e : HttpThrowable)
}