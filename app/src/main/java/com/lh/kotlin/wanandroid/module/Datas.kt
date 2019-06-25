package com.lh.kotlin.wanandroid.module

data class Datas(
    //首页
    var id: Int,
    var originId: Int,
    var title: String,
    var chapterId: Int,
    var chapterName: String?,
    var envelopePic: String,
    var link: String,
    var author: String,
    var origin: String,
    var publishTime: Long,
    var zan: String,
    var desc: String,
    var visible: Int,
    var niceDate: String,
    var courseId: Int,
    var collect: Boolean,

    // 体系下的文章 上面可以复用
    var apkLink:String,
    var fresh:String,
    var prefix:String,
    var projectLink:String,
    var superChapterId:String,
    var superChapterName:String,
    var type:Int,
    var userId:Int
)