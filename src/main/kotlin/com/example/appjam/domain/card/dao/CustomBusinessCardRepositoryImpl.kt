package com.example.appjam.domain.card.dao

import com.example.appjam.domain.card.domain.BusinessCard
import com.example.appjam.domain.card.domain.QBusinessCard.businessCard
import com.example.appjam.global.type.JobType
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class CustomBusinessCardRepositoryImpl(
    val jpaQueryFactory: JPAQueryFactory
) : CustomBusinessCardRepository {
    override fun findByJob(job: JobType?): List<BusinessCard> {
        return jpaQueryFactory
            .selectFrom(businessCard)
            .where(eqJob(job))
            .fetch()
    }

    private fun eqJob(job: JobType?): BooleanExpression? {
        return job?.let {
            businessCard.job.eq(job)
        }
    }
}
