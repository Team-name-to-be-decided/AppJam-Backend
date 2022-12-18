package com.example.appjam.domain.profile.exception

import com.example.appjam.global.error.exception.AppJamException
import com.example.appjam.global.error.exception.ErrorCode

class ProfileNotFoundException : AppJamException(ErrorCode.PROFILE_NOT_FOUND) {
    companion object {
        @JvmField
        val EXCEPTION = ProfileNotFoundException()
    }
}
