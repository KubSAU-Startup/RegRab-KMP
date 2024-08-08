package com.kubsau.regrab.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

class NetworkRepo(val client: HttpClient) {
    suspend fun getDocs() = client.get(Api.apiDocs).bodyAsText()
}