package com.example.appjam.domain.profile.api

import com.example.appjam.domain.profile.application.ProfileService
import com.example.appjam.domain.profile.dto.response.ProfileResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/profile")
class ProfileController(
    val profileService: ProfileService
) {

    @GetMapping("/{id}")
    fun getProfile(@PathVariable("id") userId: Long): ProfileResponse {
        return profileService.getProfile(userId)
    }
}
