package com.example.appjam.global.error.exception

import org.springframework.http.HttpStatus

enum class ErrorCode(
    val status: Int,
    val message: String
) {
    USER_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "사용자를 찾을 수 없습니다."),
    BUSINESS_CARD_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "명함 정보를 찾을 수 없습니다."),
    PROFILE_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "프로필 정보를 찾을 수 없습니다."),

    INVALID_TOKEN(HttpStatus.UNAUTHORIZED.value(), "유효하지 않은 토큰입니다."),
    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED.value(), "만료된 토큰입니다."),
    PASSWORD_MISMATCH(HttpStatus.UNAUTHORIZED.value(), "비밀번호가 일치하지 않습니다.")
}
