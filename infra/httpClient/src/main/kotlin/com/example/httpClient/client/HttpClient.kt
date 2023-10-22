package com.example.httpClient.client

interface HttpClient {

    fun <T> request(url : String, clazz: Class<T>) : T?

    fun <T> request(url : String, clazz: Class<T>, headers : Map<String, String>) : T?
}