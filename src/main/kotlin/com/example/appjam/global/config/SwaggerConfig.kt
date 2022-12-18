package com.example.appjam.global.config

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {
    @Bean
    fun openAPI(): OpenAPI? {
        return OpenAPI()
            .info(docsInfo())
            .components(authComponents())
    }

    private fun docsInfo(): Info? {
        val license = License().apply {
            url = "https://github.com/Team-name-to-be-decided/AppJam-Backend"
            name = "2022 APPJAM M&M"
        }
        return Info()
            .title("\"M&M 서버 API 명세\"")
            .license(license)
    }

    private fun authComponents(): Components {
        return Components().addSecuritySchemes(
            "Authorization",
            SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT")
        )
    }
}
