package com.example.api.service

import com.example.mysql.entity.UserEntity
import org.springframework.stereotype.Service
import com.example.mysql.repository.user.reader.UserReader
import com.example.mysql.repository.user.writer.UserWriter

@Service
class UserService (_userReader: UserReader, _userWriter : UserWriter) {
    private val userReader = _userReader
    private val userWriter = _userWriter

    fun save() : UserEntity{
        val user = UserEntity()
        userWriter.save(user);

        return user;
    }
}
