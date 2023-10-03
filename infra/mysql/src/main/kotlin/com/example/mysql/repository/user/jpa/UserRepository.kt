package com.example.mysql.repository.user.jpa

import com.example.mysql.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface UserRepository : JpaRepository<UserEntity, Long?> {
}