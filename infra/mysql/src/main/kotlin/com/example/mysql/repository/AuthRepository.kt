package com.example.mysql.repository

import com.example.mysql.entity.AuthEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthRepository : JpaRepository<AuthEntity, Long?> {
}