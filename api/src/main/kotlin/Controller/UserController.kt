package com.example.api.Controller

import com.example.api.service.UserService
import com.example.mysql.entity.UserEntity
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class UserController(_userService : UserService) {
    private final val userService : UserService = _userService

    @GetMapping("/test")
    fun test() : ResponseEntity<UserEntity>{
        val user = userService.save();
        return ResponseEntity(user, HttpStatus.OK)
    }
}