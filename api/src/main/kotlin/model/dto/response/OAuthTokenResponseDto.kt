package com.example.api.model.dto.response


class OAuthTokenResponseDto {
    var accessToken: String? = null
    var refreshToken: String? = null
    var tokenType: String? = null
    var expiresIn: Int? = null
    var error: String? = null
    var errorDescription: String? = null
}