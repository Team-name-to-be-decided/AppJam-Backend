package com.example.appjam.domain.card.domain

import com.example.appjam.domain.user.domain.User
import com.example.appjam.global.type.JobType
import javax.persistence.*

@Entity
class BusinessCard(
    user: User,
    name: String,
    contact: String,
    link: String,
    department: String,
    job: JobType
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    var name = name

    var contact = contact

    var link = link

    var department = department

    @Enumerated(EnumType.STRING)
    var job = job

    @OneToOne
    @JoinColumn(name = "user_id")
    val user = user
}
