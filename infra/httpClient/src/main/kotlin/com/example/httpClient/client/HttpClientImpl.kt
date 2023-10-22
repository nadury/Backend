package com.example.httpClient.client

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.codec.json.Jackson2JsonDecoder
import org.springframework.stereotype.Component
import org.springframework.util.MimeType
import org.springframework.web.reactive.function.client.ExchangeStrategies
import org.springframework.web.reactive.function.client.WebClient
import java.nio.charset.StandardCharsets

@Component
class HttpClientImpl(val mapper : ObjectMapper): HttpClient {


    override fun <T> request(url: String, clazz: Class<T>): T? {
        val strategies: ExchangeStrategies = ExchangeStrategies.builder()
            .codecs { clientCodecConfigurer ->
                clientCodecConfigurer.defaultCodecs().jackson2JsonDecoder(Jackson2JsonDecoder(mapper))
        }.build()

        val webClient = WebClient.builder()
            .exchangeStrategies(strategies)
            .baseUrl(url)
            .build()

        return webClient.get()
            .retrieve()
            .bodyToMono(clazz)
            .block()
    }

    override fun <T> request(url: String, clazz: Class<T>, headers: Map<String, String>): T? {
        val strategies: ExchangeStrategies = ExchangeStrategies.builder()
            .codecs { clientCodecConfigurer ->
                clientCodecConfigurer.defaultCodecs().jackson2JsonDecoder(Jackson2JsonDecoder(mapper))
            }.build()

        val webClient = WebClient.builder()
            .exchangeStrategies(strategies)
            .baseUrl(url)
            .build()

        return webClient.get()
            .headers { header -> headers.forEach(header::add) }
            .retrieve()
            .bodyToMono(clazz)
            .block()
    }
}