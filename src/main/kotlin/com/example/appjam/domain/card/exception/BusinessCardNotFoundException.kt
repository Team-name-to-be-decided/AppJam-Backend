package com.example.appjam.domain.card.exception

import com.example.appjam.global.error.exception.AppJamException
import com.example.appjam.global.error.exception.ErrorCode

class BusinessCardNotFoundException : AppJamException(ErrorCode.BUSINESS_CARD_NOT_FOUND) {
    companion object {
        @JvmField
        val EXCEPTION = BusinessCardNotFoundException()
    }
}
