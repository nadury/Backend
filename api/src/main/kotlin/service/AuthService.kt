package com.example.api.service

import com.example.api.component.auth.OAuthConfigManager
import com.example.api.model.dto.response.OAuthTokenResponseDto
import com.example.api.model.enums.OAuthProvider
import com.example.httpClient.client.HttpClient
import com.example.mysql.repository.auth.reader.AuthReader
import com.example.mysql.repository.auth.writer.AuthWriter
import org.springframework.stereotype.Service
import java.net.URI

@Service
class AuthService(
    private val authReader : AuthReader,
    private val authWriter : AuthWriter,
    private val httpClient : HttpClient,
    private val oAuthConfigManager: OAuthConfigManager,
) {
    fun getOAuthLoginUrl(providerStr : String) : URI?{
        val provider = OAuthProvider.from(providerStr.uppercase())
        val authConfig = oAuthConfigManager.getOAuthConfig(provider)

        return authConfig?.createLoginUrl();
    }

    fun loginOauth(providerStr: String, code: String) {
        val provider = OAuthProvider.from(providerStr.uppercase())
        val authConfig = oAuthConfigManager.getOAuthConfig(provider) ?: return

        val tokenUrl = authConfig.createTokenUrl(code)
        // TODO: oauth login 
    }


}