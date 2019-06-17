package com.lh.kotlin.wanandroid.http

import com.lh.kotlin.wanandroid.module.HomeListData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("article/list/{index}/json")
    fun getHomeList(@Path("index")index:Int ): Observable<BaseResponse<HomeListData>>
}