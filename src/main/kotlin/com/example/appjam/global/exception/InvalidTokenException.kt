package com.example.appjam.global.exception

import com.example.appjam.global.error.exception.AppJamException
import com.example.appjam.global.error.exception.ErrorCode

class InvalidTokenException : AppJamException(ErrorCode.INVALID_TOKEN) {
    companion object {
        @JvmField
        val EXCEPTION = InvalidTokenException()
    }
}
