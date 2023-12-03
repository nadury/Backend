package com.example.api.config.auth

import com.example.api.model.enums.OAuthGrantType
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI

@Configuration
class GoogleOAuthConfig (
    @Value("\${spring.oauth2.client.registration.google.client-id}") _clientId : String,
    @Value("\${spring.oauth2.client.registration.google.client-secret}") _clientSecret : String,
    @Value("\${spring.oauth2.client.registration.google.redirect-uri}") _redirectUri : String,
    @Value("\${spring.oauth2.client.provider.google.login-url}") _loginUrl : String,
    @Value("\${spring.oauth2.client.provider.google.token-url}") _tokenUrl : String,
    @Value("\${spring.oauth2.client.provider.google.resource-url}") _resourceUrl : String,
) : OAuthConfig() {
    override val clientId: String = _clientId
    override val clientSecret: String = _clientSecret
    override val loginUrl: String = _loginUrl
    override val tokenUrl: String = _tokenUrl
    override val redirectUrl: String = _redirectUri
    override val providerName: String = "google"
    override val meUrl: String = _resourceUrl
    override var grantType: OAuthGrantType = OAuthGrantType.AUTHORIZATION_CODE
    override var state: String = "NADURY_GOOGLE_OAUTH2_STATE"

    override fun createLoginUrl() : URI {
        return UriComponentsBuilder.newInstance()
            .uri(URI.create(loginUrl))
            .queryParam("response_type", "code")
            .queryParam("client_id", clientId)
            .queryParam("redirect_uri", redirectUrl)
            .queryParam("state", state)
            .queryParam("access_type", "offline")
            .queryParam("include_granted_scopes", true)
            .queryParam("scope", "https://www.googleapis.com/auth/drive.metadata.readonly")
            .build()
            .toUri()
    }

    override fun createTokenUrl(code : String) : URI {
        return UriComponentsBuilder.newInstance()
            .uri(URI.create(tokenUrl))
            .queryParam("grant_type", grantType.grantType)
            .queryParam("client_id", clientId)
            .queryParam("client_secret", clientSecret)
            .queryParam("code", code)
            .queryParam("state", state)
            .queryParam("access_type", "offline")
            .queryParam("include_granted_scopes", true)
            .queryParam("scope", "https://www.googleapis.com/auth/drive.metadata.readonly")
            .build()
            .toUri()
    }
}