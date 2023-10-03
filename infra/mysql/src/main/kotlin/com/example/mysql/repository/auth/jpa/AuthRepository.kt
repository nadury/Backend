package com.example.mysql.repository.auth.jpa

import com.example.mysql.entity.AuthEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface AuthRepository : JpaRepository<AuthEntity, Long?> {
}