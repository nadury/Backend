package com.example.api.controller

import com.example.api.service.AuthService
import com.example.api.service.LoginService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/api/auth")
class AuthController(_authService : AuthService, _loginService: LoginService) {
    private val authService = _authService
    private val loginService = _loginService

    @GetMapping("oauth/{provider}")
    fun oAuthLogin(@PathVariable("provider") provider : String) : ResponseEntity<*> {
        val loginUrl = authService.getOAuthLoginUrl(provider)
        val header = HttpHeaders()
        header.location = loginUrl

        return ResponseEntity(null, header, HttpStatus.MOVED_PERMANENTLY);
    }

    @GetMapping("oauth/callback/{provider}")
    fun oAuthLoginCallback (
        @PathVariable("provider") provider : String,
        @RequestParam(name = "code") code : String,
        @RequestParam(name = "state", required = false) state : String,
        request : HttpServletRequest,
        response: HttpServletResponse
    ) : ResponseEntity<*> {
        // TODO: oauth login
        loginService.socialLogin(code, provider)

        return ResponseEntity(null, null, HttpStatus.OK);
    }


}