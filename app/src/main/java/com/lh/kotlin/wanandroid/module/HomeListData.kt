package com.lh.kotlin.wanandroid.module

data class HomeListData (
    var offset: Int,
    var size: Int,
    var total: Int,
    var pageCount: Int,
    var curPage: Int,
    var over: Boolean,
    var datas: List<Datas>?
)