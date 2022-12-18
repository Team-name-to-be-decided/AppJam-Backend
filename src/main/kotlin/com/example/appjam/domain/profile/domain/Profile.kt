package com.example.appjam.domain.profile.domain

import com.example.appjam.domain.user.domain.User
import com.example.appjam.global.type.JobType
import javax.persistence.*

@Entity
class Profile(
    user: User,
    hobby: String,
    job: JobType,
    interest: String,
    technologies: String,
    contact: String,
    introduction: String
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @OneToOne
    @JoinColumn(name = "user_id")
    val user = user

    var hobby = hobby

    @Enumerated(EnumType.STRING)
    var job = job

    var interest = interest

    var technologies = technologies

    var contact = contact

    var introduction = introduction
}
