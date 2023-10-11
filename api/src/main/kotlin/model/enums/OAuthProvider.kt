package com.example.api.model.enums

enum class OAuthProvider(val provider : String) {
    NAVER("NAVER"),
    KAKAO("KAKAO"),
    GOOGLE("GOOGLE")
    ;

    companion object {
        fun from(value: String): OAuthProvider =  requireNotNull(values().find { it.provider == value }) { "No OAuthProvider with value $value" }
    }

}