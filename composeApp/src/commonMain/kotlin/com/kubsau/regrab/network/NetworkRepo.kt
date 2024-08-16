package com.kubsau.regrab.network

import com.kubsau.regrab.network.models.BaseResponse
import com.kubsau.regrab.network.models.response.AuthResponse
import com.kubsau.regrab.storage.AccountStorage
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.forms.submitForm
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.client.statement.bodyAsText
import io.ktor.http.parameters

class NetworkRepo(
    private val client: HttpClient,
    private val storage: AccountStorage
) {
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

    suspend fun auth(authData: Map<String, String>): ResponseState {
        return try {
            val response = client.submitForm(
                url = Api.AUTH,
                formParameters = parameters {
                    authData.forEach {
                        append(it.key, it.value)
                    }
                }
            ).body<BaseResponse<AuthResponse>>()

            if (response.success) {
                storage.updateAccount { account ->
                    account.copy(
                        token = response.response?.accessToken.toString()
                    )
                }
                ResponseState.Success
            } else {
                when (response.error?.code) {
                    CONST_WRONG_CREDENTIALS_ERROR -> ResponseState.WrongCredentials
                    CONST_WRONG_PASSWORD_ERROR -> ResponseState.WrongPassword
                    else -> ResponseState.UnknownError
                }
            }

        } catch (e: RedirectResponseException) {
            //3xx
            ResponseState.Redirect
        } catch (e: ClientRequestException) {
            //4xx
            ResponseState.ClientError
        } catch (e: ServerResponseException) {
            //5xx
            ResponseState.ServerError
        } catch (e: ResponseException) {
            e.printStackTrace()
            ResponseState.UnknownError
        }
    }
}