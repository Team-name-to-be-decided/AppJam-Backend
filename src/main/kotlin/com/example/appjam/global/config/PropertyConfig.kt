package com.example.appjam.global.config

import com.example.appjam.BASE_PACKAGE
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationPropertiesScan(basePackages = [BASE_PACKAGE])
class PropertyConfig
