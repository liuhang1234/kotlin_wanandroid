package com.lh.kotlin.wanandroid.http

import com.lh.kotlin.wanandroid.module.HomeListData
import com.lh.kotlin.wanandroid.module.TreeListData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    /**
     * 首页
     */
    @GET("article/list/{index}/json")
    fun getHomeList(@Path("index")index:Int ): Observable<BaseResponse<HomeListData>>

    @GET("/tree/json")
    fun getTreeList():Observable<BaseResponse<List<TreeListData>>>
}