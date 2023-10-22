package com.example.httpClient.client

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.codec.json.Jackson2JsonDecoder
import org.springframework.stereotype.Component
import org.springframework.util.MimeType
import org.springframework.web.reactive.function.client.ExchangeStrategies
import org.springframework.web.reactive.function.client.WebClient
import java.nio.charset.StandardCharsets

@Component
class HttpClientImpl(
    val mapper : ObjectMapper,
    val webClient : WebClient
): HttpClient {


    override fun <TResult> get(url: String, clazz: Class<TResult>): TResult? = get(url, clazz, HashMap<String, String>())

    override fun <TResult> get(url: String, clazz: Class<TResult>, headers: Map<String, String>): TResult? {
        return webClient.mutate()
            .baseUrl(url)
            .build()
            .get()
            .headers { header -> headers.forEach(header::add) }
            .retrieve()
            .bodyToMono(clazz)
            .block()
    }

    override fun <TBody, TResult> post(url: String, body: TBody, clazz: Class<TResult>): TResult? {
        TODO("Not yet implemented")
    }

    override fun <TBody, TResult> post(
        url: String,
        body: TBody,
        clazz: Class<TResult>,
        headers: Map<String, String>
    ): TResult? {
        TODO("Not yet implemented")
    }
}