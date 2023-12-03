package com.example.api.component.auth

import com.example.api.config.auth.GoogleOAuthConfig
import com.example.api.config.auth.NaverOAuthConfig
import com.example.api.config.auth.OAuthConfig
import com.example.api.model.enums.OAuthProvider
import org.springframework.stereotype.Component

@Component
class OAuthConfigManager(
    val naverOAuthConfig: NaverOAuthConfig,
    val googleOAuthConfig: GoogleOAuthConfig
) {

    fun getOAuthConfig(provider: OAuthProvider) : OAuthConfig?{
        when(provider){
            OAuthProvider.NAVER -> return naverOAuthConfig
            OAuthProvider.KAKAO -> return null
            OAuthProvider.GOOGLE -> return googleOAuthConfig
            else -> return null
        }
    }


}