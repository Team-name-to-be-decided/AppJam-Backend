package com.example.appjam.domain.card.api

import com.example.appjam.domain.card.application.BusinessCardService
import com.example.appjam.domain.card.dto.response.BusinessCardResponse
import com.example.appjam.domain.card.dto.response.BusinessCardsResponse
import com.example.appjam.global.type.JobType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cards")
class BusinessCardController(
    val businessCardService: BusinessCardService
) {

    @GetMapping
    fun getBusinessCards(@RequestParam(required = false) job: JobType?): BusinessCardsResponse {
        return businessCardService.getBusinessCards(job)
    }

    @GetMapping("/{id}")
    fun getBusinessCard(@PathVariable("id") cardId: Long): BusinessCardResponse {
        return businessCardService.getBusinessCard(cardId)
    }
}
