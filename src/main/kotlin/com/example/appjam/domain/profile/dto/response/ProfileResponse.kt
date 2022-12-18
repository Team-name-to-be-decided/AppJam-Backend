package com.example.appjam.domain.profile.dto.response

import com.querydsl.core.annotations.QueryProjection

class ProfileResponse @QueryProjection constructor(
    val name: String,
    val email: String,
    val link: String,
    val department: String,
    val hobby: String,
    val technologies: String,
    val introduction: String
)
