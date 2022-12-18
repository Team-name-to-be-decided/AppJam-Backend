package com.example.appjam.domain.card.application

import com.example.appjam.domain.card.dao.BusinessCardRepository
import com.example.appjam.domain.card.dto.response.BusinessCardResponse
import com.example.appjam.domain.card.dto.response.BusinessCardsResponse
import com.example.appjam.domain.card.exception.BusinessCardNotFoundException
import com.example.appjam.global.type.JobType
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class BusinessCardService(
    val businessCardRepository: BusinessCardRepository
) {

    @Transactional(readOnly = true)
    fun getBusinessCards(jobType: JobType?): BusinessCardsResponse {
        val cards = businessCardRepository.findByJob(jobType)

        return BusinessCardsResponse.from(cards)
    }

    @Transactional(readOnly = true)
    fun getBusinessCard(cardId: Long): BusinessCardResponse {
        val card = businessCardRepository.findByIdOrNull(cardId)
            ?: throw BusinessCardNotFoundException.EXCEPTION

        return BusinessCardResponse.from(card)
    }
}
