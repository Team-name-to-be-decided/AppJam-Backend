package com.example.appjam.domain.card.dto.response

import com.example.appjam.domain.card.domain.BusinessCard

class BusinessCardsResponse private constructor(
    val businessCards: List<BusinessCardResponse>
) {
    companion object {
        fun from(businessCards: List<BusinessCard>): BusinessCardsResponse {
            return BusinessCardsResponse(
                businessCards.map { card ->
                    BusinessCardResponse.from(card)
                }
            )
        }
    }
}
