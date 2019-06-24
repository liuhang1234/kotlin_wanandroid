package com.lh.kotlin.wanandroid.module

import java.io.Serializable

/**
 * Created by lh
 * time: 2019/6/24
 */
data class TreeListData(
    var id: Int,
    var name: String,
    var courseId: Int,
    var parentChapterId: Int,
    var order: Int,
    var visible: Int,
    var children: List<Children>?
) : Serializable {
    data class Children(
        var id: Int,
        var name: String,
        var courseId: Int,
        var parentChapterId: Int,
        var order: Int,
        var visible: Int,
        var children: List<Children>?
    ) : Serializable
}