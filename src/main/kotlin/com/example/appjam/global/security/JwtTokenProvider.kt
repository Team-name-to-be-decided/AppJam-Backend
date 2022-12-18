package com.example.appjam.global.security

import com.example.appjam.global.exception.ExpiredTokenException
import com.example.appjam.global.exception.InvalidTokenException
import com.example.appjam.global.property.JwtProperties
import com.example.appjam.global.security.auth.AuthDetailsService
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.security.Key
import java.util.*
import javax.servlet.http.HttpServletRequest

@Component
class JwtTokenProvider(
    val jwtProperties: JwtProperties,
    val authDetailsService: AuthDetailsService
) {
    fun generateAccessToken(userId: Long): String {
        return generateToken(userId, "access", jwtProperties.accessExp)
    }

    fun generateRefreshToken(userId: Long): String {
        return generateToken(userId, "refresh", jwtProperties.refreshExp)
    }

    private fun generateToken(userId: Long, type: String, exp: Long): String {
        val key: Key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtProperties.secretKey))
        return Jwts.builder()
            .signWith(key)
            .setSubject(userId.toString())
            .claim("type", type)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + exp * 1000 * 60))
            .compact()
    }

    fun getTokenFromHeader(request: HttpServletRequest): String? {
        val bearerToken: String? = request.getHeader(jwtProperties.header)
        return parseToken(bearerToken)
    }

    private fun parseToken(bearerToken: String?): String? {
        return if (bearerToken != null && bearerToken.startsWith(jwtProperties.prefix)) {
            bearerToken.substring(7)
        } else null
    }

    fun getTokenBody(token: String): Claims {
        val key: Key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtProperties.secretKey))
        return try {
            Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token).body
        } catch (e: ExpiredJwtException) {
            throw ExpiredTokenException.EXCEPTION
        } catch (e: Exception) {
            throw InvalidTokenException.EXCEPTION
        }
    }

    fun getAuthentication(tokenBody: Claims): Authentication {
        if (!isAccessToken(tokenBody)) {
            throw InvalidTokenException.EXCEPTION
        }
        val userDetails = authDetailsService.loadUserByUsername(getUserId(tokenBody))
        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }

    private fun isAccessToken(tokenBody: Claims): Boolean {
        return tokenBody.get("type", String::class.java) == "access"
    }

    fun isRefreshToken(tokenBody: Claims): Boolean {
        return tokenBody.get("type", String::class.java) == "refresh"
    }

    fun getUserId(tokenBody: Claims): String {
        return tokenBody.subject
    }
}
