package com.example.appjam.domain.card.dao

import com.example.appjam.domain.card.domain.BusinessCard
import com.example.appjam.global.type.JobType

interface CustomBusinessCardRepository {
    fun findByJob(job: JobType?): List<BusinessCard>
}
