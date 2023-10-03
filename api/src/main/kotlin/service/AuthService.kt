package com.example.api.service

import com.example.api.component.auth.OAuthConfigManager
import com.example.api.model.enums.OAuthProvider
import com.example.mysql.repository.auth.reader.AuthReader
import com.example.mysql.repository.auth.writer.AuthWriter
import org.springframework.stereotype.Service
import java.net.URI

@Service
class AuthService(
    private val authReader : AuthReader,
    private val authWriter : AuthWriter,
    private val oAuthConfigManager: OAuthConfigManager,
) {


    fun getOAuthLoginUrl(providerStr : String) : URI?{
        val provider = enumValueOf<OAuthProvider>(providerStr);
        val authConfig = oAuthConfigManager.getOAuthConfig(provider)

        return authConfig?.createLoginUrl();
    }
}