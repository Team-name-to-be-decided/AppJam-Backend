package com.example.appjam

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AppJamBackendApplication

fun main(args: Array<String>) {
    runApplication<AppJamBackendApplication>(*args)
}
