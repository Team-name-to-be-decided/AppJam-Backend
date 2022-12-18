package com.example.appjam.domain.profile.dao

import com.example.appjam.domain.profile.domain.Profile
import org.springframework.data.jpa.repository.JpaRepository

interface ProfileRepository : JpaRepository<Profile, Long>, CustomProfileRepository
