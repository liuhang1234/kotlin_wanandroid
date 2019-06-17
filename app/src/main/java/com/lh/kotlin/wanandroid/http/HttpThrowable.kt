package com.lh.kotlin.wanandroid.http

import java.lang.Exception

class HttpThrowable :Throwable {
    /**失败状态码 */
    var code = -1

    constructor() {}

    constructor(message: String) : super(message) {}

    constructor(code: Int, message: String) : super(message) {
        this.code = code
    }
}