package com.example.appjam.domain.user.domain

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
class User(
    email: String,
    password: String
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @NotNull
    @Column(unique = true)
    val email: String = email

    @NotNull
    var password: String = password
        protected set
}
