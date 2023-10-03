package com.example.mysql.repository.user.writer

import com.example.mysql.entity.UserEntity
import com.example.mysql.repository.user.jpa.UserRepository
import org.springframework.stereotype.Repository

@Repository
class UserWriterImpl(_userRepository : UserRepository) : UserWriter {
    private val userRepository = _userRepository

    override fun save(user: UserEntity) {
        userRepository.save(user)
    }
}