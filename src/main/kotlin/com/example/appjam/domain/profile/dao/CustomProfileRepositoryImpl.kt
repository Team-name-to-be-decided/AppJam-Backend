package com.example.appjam.domain.profile.dao

import com.example.appjam.domain.card.domain.QBusinessCard.businessCard
import com.example.appjam.domain.profile.domain.QProfile.profile
import com.example.appjam.domain.profile.dto.response.ProfileResponse
import com.example.appjam.domain.profile.dto.response.QProfileResponse
import com.example.appjam.domain.user.domain.QUser.user
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class CustomProfileRepositoryImpl(
    val jpaQueryFactory: JPAQueryFactory
) : CustomProfileRepository {
    override fun findByUserId(userId: Long): ProfileResponse? {
        return jpaQueryFactory
            .select(
                QProfileResponse(
                    businessCard.name,
                    user.email,
                    businessCard.link,
                    businessCard.department,
                    profile.hobby,
                    profile.technologies,
                    profile.introduction
                )
            )
            .from(profile)
            .leftJoin(user).on(user.id.eq(profile.user.id))
            .leftJoin(businessCard).on(businessCard.user.id.eq(profile.user.id))
            .where(user.id.eq(userId))
            .fetchOne()
    }
}
