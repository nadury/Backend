package com.example.api.config.auth

import com.example.api.model.enums.OAuthGrantType
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI

abstract class OAuthConfig {
    abstract val clientId : String

    abstract val clientSecret : String

    abstract val loginUrl : String

    abstract val tokenUrl : String

    abstract val meUrl : String

    abstract val redirectUrl : String

    abstract val providerName : String

    open var state : String = "nadury_default_state"

    abstract var grantType : OAuthGrantType


    fun createLoginUrl() : URI {
        return UriComponentsBuilder.newInstance()
            .uri(URI.create(loginUrl))
            .queryParam("response_type", "code")
            .queryParam("client_id", clientId)
            .queryParam("redirect_uri", redirectUrl)
            .queryParam("state", state)
            .build()
            .toUri()
    }

    fun createTokenUrl(code : String) : URI {
        return UriComponentsBuilder.newInstance()
            .uri(URI.create(tokenUrl))
            .queryParam("grant_type", grantType.grantType)
            .queryParam("client_id", clientId)
            .queryParam("client_secret", clientSecret)
            .queryParam("code", code)
            .queryParam("state", state)
            .build()
            .toUri()
    }

    fun createMeUrl() : URI{
        return URI.create(meUrl)
    }
}