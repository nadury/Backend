package com.example.mysql.repository.auth.writer

import com.example.mysql.entity.AuthEntity
import com.example.mysql.repository.auth.jpa.AuthRepository
import org.springframework.stereotype.Repository

@Repository
class AuthWriterImpl(_authRepository : AuthRepository) : AuthWriter {
    private val authRepository = _authRepository

    override fun save(auth: AuthEntity) {
         authRepository.save(auth)
    }
}