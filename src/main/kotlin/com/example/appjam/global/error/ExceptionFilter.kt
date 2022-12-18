package com.example.appjam.global.error

import com.example.appjam.global.error.exception.AppJamException
import com.example.appjam.global.error.exception.ErrorCode
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ExceptionFilter(
    private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: AppJamException) {
            response.contentType = MediaType.APPLICATION_JSON_VALUE
            response.writer.write(objectMapper.writeValueAsString(getErrorResponse(e.errorCode)))
        }
    }

    private fun getErrorResponse(errorCode: ErrorCode): ErrorResponse {
        return ErrorResponse(errorCode.message)
    }
}
