package com.example.api.controller

import com.example.api.service.AuthService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class AuthController(_authService : AuthService) {
    private val authService = _authService

    @GetMapping("oauth/{provider}")
    fun oAuthLogin(@PathVariable("provider") provider : String) : ResponseEntity<*> {
        val loginUrl = authService.getOAuthLoginUrl(provider)
        val header = HttpHeaders()
        header.location = loginUrl

        return ResponseEntity(null, header, HttpStatus.MOVED_PERMANENTLY);
    }


}