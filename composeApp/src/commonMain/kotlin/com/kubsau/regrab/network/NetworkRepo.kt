package com.kubsau.regrab.network

import com.kubsau.regrab.network.models.BaseResponse
import com.kubsau.regrab.network.models.request.AuthRequest
import com.kubsau.regrab.network.models.response.AuthResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType

class NetworkRepo(val client: HttpClient) {
    suspend fun getDocs(): String {
        return try {
            client.get {
                url(Api.API_DOCS)
            }.bodyAsText()
        } catch (e: RedirectResponseException) {
            //3xx
            "Redirect"
        } catch (e: ClientRequestException) {
            //4xx
            "Client error"
        } catch (e: ServerResponseException) {
            //5xx
            "Server error"
        } catch (e: ResponseException) {
            e.response.status.description
        }
    }

    suspend fun auth(authData: AuthRequest): String? {
        return try {
            val response = client.post {
                url(Api.AUTH)
                contentType(ContentType.Application.Json)
                setBody(authData)
            }

            response.body<BaseResponse<AuthResponse>>().toString()
        } catch (e: ResponseException) {
            null
        }
    }
}