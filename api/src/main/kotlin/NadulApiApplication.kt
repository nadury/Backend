package com.example.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication(scanBasePackages = ["com.example"])
class NadulApiApplication

fun main(args: Array<String>){
    runApplication<NadulApiApplication>()
}
