package com.example.appjam.domain.user.api

import com.example.appjam.domain.user.application.UserService
import com.example.appjam.domain.user.dto.request.LoginRequest
import com.example.appjam.domain.user.dto.request.SignUpRequest
import com.example.appjam.domain.user.dto.response.TokenResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(
    val userService: UserService
) {

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    fun signUp(@RequestBody request: SignUpRequest): TokenResponse {
        return userService.signUp(request)
    }

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): TokenResponse {
        return userService.login(request)
    }
}
