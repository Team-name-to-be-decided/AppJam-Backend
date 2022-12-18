package com.example.appjam.domain.card.dto.response

import com.example.appjam.domain.card.domain.BusinessCard
import com.example.appjam.global.type.JobType

class BusinessCardResponse private constructor(
    val id: Long,
    val name: String,
    val job: JobType,
    val department: String,
    val link: String
) {
    companion object {
        fun from(businessCard: BusinessCard): BusinessCardResponse {
            return BusinessCardResponse(
                id = businessCard.id,
                name = businessCard.name,
                job = businessCard.job,
                department = businessCard.department,
                link = businessCard.link
            )
        }
    }
}
