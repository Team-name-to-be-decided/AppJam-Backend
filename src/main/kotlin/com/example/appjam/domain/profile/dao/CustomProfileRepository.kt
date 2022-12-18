package com.example.appjam.domain.profile.dao

import com.example.appjam.domain.profile.dto.response.ProfileResponse

interface CustomProfileRepository {
    fun findByUserId(userId: Long): ProfileResponse?
}
