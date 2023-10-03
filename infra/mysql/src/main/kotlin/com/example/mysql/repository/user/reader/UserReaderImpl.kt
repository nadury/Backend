package com.example.mysql.repository.user.reader

import com.example.mysql.entity.UserEntity
import com.example.mysql.repository.user.jpa.UserRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import kotlin.jvm.optionals.getOrNull

@Repository
class UserReaderImpl(_userRepository: UserRepository) : UserReader {
    private val userRepository = _userRepository

    override fun findById(id: Long): UserEntity? {
        return userRepository.findById(id).orElse(null)
    }

}