package com.example.appjam.domain.user.exception

import com.example.appjam.global.error.exception.AppJamException
import com.example.appjam.global.error.exception.ErrorCode

class PasswordMismatchException : AppJamException(ErrorCode.PASSWORD_MISMATCH) {
    companion object {
        @JvmField
        val EXCEPTION = PasswordMismatchException()
    }
}
