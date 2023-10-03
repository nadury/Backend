package com.example.mysql.repository.auth.reader

import com.example.mysql.entity.AuthEntity

interface AuthReader {
    fun findById(id : Long) : AuthEntity?
}