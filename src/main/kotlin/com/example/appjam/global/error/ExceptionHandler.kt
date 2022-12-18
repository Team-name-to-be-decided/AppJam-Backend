package com.example.appjam.global.error

import com.example.appjam.global.error.exception.AppJamException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(AppJamException::class)
    fun appJamException(e: AppJamException): ResponseEntity<ErrorResponse> {
        return handleException(e)
    }

    private fun handleException(e: AppJamException): ResponseEntity<ErrorResponse> {
        val httpStatus = HttpStatus.valueOf(e.errorCode.status)
        val body = ErrorResponse(e.errorCode.message)
        return ResponseEntity(body, httpStatus)
    }
}
