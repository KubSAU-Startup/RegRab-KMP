package com.kubsau.regrab.network

import com.kubsau.regrab.network.models.request.AuthRequest
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.statement.bodyAsText

class NetworkRepo(val client: HttpClient) {
    suspend fun getDocs() = client.get(Api.API_DOCS).bodyAsText()

    suspend fun auth(authData:AuthRequest){
        val result = client.post(Api.AUTH)
    }
}