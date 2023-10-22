package com.example.httpClient.client

interface HttpClient {

    fun <TResult> get(url : String, clazz: Class<TResult>) : TResult?

    fun <TResult> get(url : String, clazz: Class<TResult>, headers : Map<String, String>) : TResult?

    fun <TBody, TResult> post(url: String, body: TBody, clazz: Class<TResult>): TResult?

    fun <TBody, TResult> post(url: String, body: TBody, clazz: Class<TResult>, headers: Map<String, String>): TResult?
}