package com.example.mysql.repository.auth.reader

import com.example.mysql.entity.AuthEntity
import com.example.mysql.repository.auth.jpa.AuthRepository
import org.springframework.stereotype.Repository

@Repository
class AuthReaderImpl(_authRepository : AuthRepository) : AuthReader {
    private val authRepository = _authRepository

    override fun findById(id: Long): AuthEntity? {
         return authRepository.findById(id).orElse(null)
    }
}