package com.example.appjam.domain.user.application

import com.example.appjam.domain.card.dao.BusinessCardRepository
import com.example.appjam.domain.card.domain.BusinessCard
import com.example.appjam.domain.profile.dao.ProfileRepository
import com.example.appjam.domain.profile.domain.Profile
import com.example.appjam.domain.user.dao.UserRepository
import com.example.appjam.domain.user.domain.User
import com.example.appjam.domain.user.dto.request.LoginRequest
import com.example.appjam.domain.user.dto.request.SignUpRequest
import com.example.appjam.domain.user.dto.response.TokenResponse
import com.example.appjam.domain.user.exception.PasswordMismatchException
import com.example.appjam.global.exception.UserNotFoundException
import com.example.appjam.global.security.JwtTokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserService(
    val passwordEncoder: PasswordEncoder,
    val userRepository: UserRepository,
    val profileRepository: ProfileRepository,
    val businessCardRepository: BusinessCardRepository,
    val jwtTokenProvider: JwtTokenProvider
) {

    fun signUp(request: SignUpRequest): TokenResponse {
        val user = User(
            email = request.email,
            password = passwordEncoder.encode(request.password)
        )
        userRepository.save(user)

        val profile = Profile(
            user = user,
            hobby = request.hobby,
            job = request.job,
            interest = request.interest,
            technologies = request.technologies,
            contact = request.contact,
            introduction = request.introduction
        )
        profileRepository.save(profile)

        val businessCard = BusinessCard(
            user = user,
            name = request.name,
            contact = request.contact,
            link = request.link,
            department = request.department,
            job = request.job
        )
        businessCardRepository.save(businessCard)

        val accessToken = jwtTokenProvider.generateAccessToken(user.id)
        val refreshToken = jwtTokenProvider.generateRefreshToken(user.id)

        return TokenResponse(accessToken, refreshToken)
    }

    fun login(request: LoginRequest): TokenResponse {
        val user = userRepository.findByEmail(request.email)
            ?: throw UserNotFoundException.EXCEPTION

        if (passwordEncoder.matches(request.password, user.password)) {
            throw PasswordMismatchException.EXCEPTION
        }

        val accessToken = jwtTokenProvider.generateAccessToken(user.id)
        val refreshToken = jwtTokenProvider.generateRefreshToken(user.id)

        return TokenResponse(accessToken, refreshToken)
    }
}
