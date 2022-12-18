package com.example.appjam.global.exception

import com.example.appjam.global.error.exception.AppJamException
import com.example.appjam.global.error.exception.ErrorCode

class UserNotFoundException : AppJamException(ErrorCode.USER_NOT_FOUND) {
    companion object {
        @JvmField
        val EXCEPTION = UserNotFoundException()
    }
}
