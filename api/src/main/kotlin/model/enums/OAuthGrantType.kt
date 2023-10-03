package com.example.api.model.enums

enum class OAuthGrantType(val grantType: String) {
    AUTHORIZATION_CODE("authorization_code"),
    REFRESH_TOKEN("refresh_token"),
    DELETE("delete");
}