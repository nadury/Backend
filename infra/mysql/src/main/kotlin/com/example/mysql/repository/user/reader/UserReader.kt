package com.example.mysql.repository.user.reader

import com.example.mysql.entity.UserEntity

interface UserReader {
    fun findById(id : Long) : UserEntity?
}