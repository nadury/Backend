package com.example.mysql.repository.auth.writer

import com.example.mysql.entity.AuthEntity
import org.springframework.stereotype.Repository

interface AuthWriter {
    fun save(auth : AuthEntity)
}