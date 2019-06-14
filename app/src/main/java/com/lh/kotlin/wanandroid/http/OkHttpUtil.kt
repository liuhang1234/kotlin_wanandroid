package com.lh.kotlin.wanandroid.http

import com.lh.kotlin.wanandroid.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object  OkHttpUtil {
    private var client: OkHttpClient? = null // client对象

    fun defaultOkHttpClient():OkHttpClient {
        if (client != null) {
            return client as OkHttpClient
        }

        var logging = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG){
            logging.level = HttpLoggingInterceptor.Level.BODY
        }else{
            logging.level = HttpLoggingInterceptor.Level.NONE
        }
        client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .connectTimeout(20,TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
        return client as OkHttpClient
    }
}