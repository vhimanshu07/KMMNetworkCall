package com.example.kmmnetworkcall

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.URLBuilder

/**
 * Created by Himanshu Verma on 28/06/24.
 **/
object RestCall {
    private val client = HttpClient()
    suspend fun fetchData(): String {

        return client.get {
            val reqUrl = URLBuilder("$baseUrl/post/2")
            url.protocol = reqUrl.protocol
            url.host = reqUrl.host
        }.toString()
    }

    private const val baseUrl = "https://jsonplaceholder.typicode.com"

}