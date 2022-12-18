package com.example.appjam.global.config

import com.example.appjam.global.security.JwtTokenProvider
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val jwtTokenProvider: JwtTokenProvider,
    private val objectMapper: ObjectMapper
) {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .formLogin().disable()
            .cors().and()
            .csrf().disable()

        http
            .authorizeHttpRequests()
            .antMatchers(*SwaggerPatterns).permitAll()
            .antMatchers("/users/login").permitAll()
            .antMatchers("/users/sign-up").permitAll()
            .anyRequest().authenticated()

        http
            .apply(FilterConfig(jwtTokenProvider, objectMapper))

        return http.build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    companion object {
        val SwaggerPatterns: Array<String> = arrayOf(
            "/swagger-resources/**",
            "/swagger-ui/**",
            "/v3/api-docs/**"
        )
    }
}
