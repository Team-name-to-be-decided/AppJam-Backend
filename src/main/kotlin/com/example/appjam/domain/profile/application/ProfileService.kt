package com.example.appjam.domain.profile.application

import com.example.appjam.domain.profile.dao.CustomProfileRepository
import com.example.appjam.domain.profile.dto.response.ProfileResponse
import com.example.appjam.domain.profile.exception.ProfileNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ProfileService(
    val profileRepository: CustomProfileRepository
) {

    @Transactional(readOnly = true)
    fun getProfile(userId: Long): ProfileResponse {
        return profileRepository.findByUserId(userId)
            ?: throw ProfileNotFoundException.EXCEPTION
    }
}
