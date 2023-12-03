package com.example.api.service

import com.example.mysql.entity.UserEntity
import com.fasterxml.jackson.databind.JsonNode
import org.springframework.core.env.Environment
import org.springframework.stereotype.Service
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.client.RestTemplate
import org.springframework.http.*;


@Service
class LoginService(val env: Environment) {
    val restTemplate: RestTemplate = RestTemplate()

    fun socialLogin(code: String, provider: String) {
        // 소셜로그인 분류
        println("code = " + code)
        println("provider = " + provider)

        var urlType: String;
        when(provider) {
            "google" -> urlType = "resource-url"
            "naver" -> urlType = "me-url"
            "kakao" -> urlType = ""
            else -> {
                urlType = ""
            }
        }

        val accessToken: String = getAccessToken(code, provider)
        val userResourceNode: JsonNode = getUserResource(accessToken, provider, urlType)

        val id: String = userResourceNode.get("id").asText()
        val email: String = userResourceNode.get("email").asText()

        // User 정보 출력
        println("id = " + id)
        println("email = " + email)
    }

    private fun getAccessToken(authorizationCode: String, provider: String): String {
        val clientId: String = env.getProperty("spring.oauth2.client.registration." + provider + ".client-id")
        val clientSecret: String = env.getProperty("spring.oauth2.client.registration." + provider + ".client-secret")
        val redirectUri: String = env.getProperty("spring.oauth2.client.registration." + provider + ".redirect-uri")
        val tokenUri: String = env.getProperty("spring.oauth2.client.provider." + provider + ".token-url")

        val params: MultiValueMap<String, String> = LinkedMultiValueMap()
        params.add("code", authorizationCode)
        params.add("client_id", clientId)
        params.add("client_secret", clientSecret)
        params.add("redirect_uri", redirectUri)
        params.add("grant_type", "authorization_code")

        val headers: HttpHeaders = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_FORM_URLENCODED

        val entity: HttpEntity<*> = HttpEntity<Any?>(params, headers)

        val responseNode: ResponseEntity<JsonNode> = restTemplate.exchange(
            tokenUri, HttpMethod.POST, entity,
            JsonNode::class.java
        )
        val accessTokenNode = responseNode.body
        return accessTokenNode["access_token"].asText();
    }

    private fun getUserResource(accessToken: String, provider: String, urlType: String): JsonNode {
        val resourceUri: String = env.getProperty("spring.oauth2.client.provider." + provider + "." + urlType)

        val headers: HttpHeaders = HttpHeaders()
        headers.set("Authorization", "Bearer" + accessToken)
        val entity: HttpEntity<Any> = HttpEntity(headers)

        return restTemplate.exchange(resourceUri, HttpMethod.GET, entity, JsonNode::class.java).getBody()
    }
}