package com.example.appjam.domain.user.dto.request

import com.example.appjam.global.type.JobType

class SignUpRequest(
    val email: String,
    val password: String,
    val hobby: String,
    val job: JobType,
    val interest: String,
    val technologies: String,
    val contact: String,
    val introduction: String,
    val name: String,
    val link: String,
    val department: String
)
