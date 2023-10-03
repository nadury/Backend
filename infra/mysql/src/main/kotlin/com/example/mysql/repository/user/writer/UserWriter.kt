package com.example.mysql.repository.user.writer

import com.example.mysql.entity.UserEntity

interface UserWriter {
    fun save(user : UserEntity)
}