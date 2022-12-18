package com.example.appjam.domain.card.dao

import com.example.appjam.domain.card.domain.BusinessCard
import org.springframework.data.jpa.repository.JpaRepository

interface BusinessCardRepository : JpaRepository<BusinessCard, Long>, CustomBusinessCardRepository
