package com.example.appjam.global.property

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "auth.jwt")
class JwtProperties(
    var header: String,
    var prefix: String,
    var secretKey: String,
    var accessExp: Long,
    var refreshExp: Long
)
