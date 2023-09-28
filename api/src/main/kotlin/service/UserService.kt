package com.example.api.service

import com.example.mysql.entity.UserEntity
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import com.example.mysql.repository.UserRepository

@Service
//@RequiredArgsConstructor
class UserService (_userRepository: UserRepository) {
    private val userRepository: UserRepository = _userRepository

    fun save() : UserEntity{
        val user = UserEntity()
        userRepository.save(user);

        return user;
    }
}
