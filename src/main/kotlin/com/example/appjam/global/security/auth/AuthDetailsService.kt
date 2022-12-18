package com.example.appjam.global.security.auth

import com.example.appjam.domain.user.dao.UserRepository
import com.example.appjam.global.exception.UserNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthDetailsService(
    val userRepository: UserRepository
) : UserDetailsService {
    override fun loadUserByUsername(userId: String): UserDetails {
        val user = userRepository.findByIdOrNull(userId.toLong())
            ?: throw UserNotFoundException.EXCEPTION

        return AuthDetails(user.id.toString())
    }
}
