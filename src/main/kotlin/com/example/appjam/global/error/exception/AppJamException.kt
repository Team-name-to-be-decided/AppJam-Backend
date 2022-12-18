package com.example.appjam.global.error.exception

open class AppJamException(
    val errorCode: ErrorCode
) : RuntimeException() {

    override fun fillInStackTrace(): Throwable {
        return this
    }
}
