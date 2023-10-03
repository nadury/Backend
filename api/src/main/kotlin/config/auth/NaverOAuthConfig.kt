package com.example.api.config.auth

import com.example.api.model.enums.OAuthGrantType
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
class NaverOAuthConfig(
    @Value("\${spring.oauth2.client.registration.naver.client-id}") _clientId : String,
    @Value("\${spring.oauth2.client.registration.naver.client-secret}") _clientSecret : String,
    @Value("\${spring.oauth2.client.registration.naver.redirect-uri}") _redirectUri : String,
    @Value("\${spring.oauth2.client.provider.naver.login-url}") _loginUrl : String,
    @Value("\${spring.oauth2.client.provider.naver.token-url}") _tokenUrl : String,
    @Value("\${spring.oauth2.client.provider.naver.me-url}") _meUrl : String,
) : OAuthConfig() {
    override val clientId: String = _clientId
    override val clientSecret: String = _clientSecret
    override val loginUrl: String = _loginUrl
    override val tokenUrl: String = _tokenUrl
    override val meUrl: String = _meUrl
    override val redirectUrl: String = _redirectUri
    override val providerName: String = "naver"
    override var grantType: OAuthGrantType = OAuthGrantType.AUTHORIZATION_CODE

}