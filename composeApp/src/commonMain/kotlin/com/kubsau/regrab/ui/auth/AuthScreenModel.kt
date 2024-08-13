package com.kubsau.regrab.ui.auth

import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.kubsau.regrab.network.NetworkRepo
import com.kubsau.regrab.network.ResponseState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AuthScreenModel(
    private val repo: NetworkRepo
) : ScreenModel {
    var login = mutableStateOf("vasilenko.i2")
        private set

    var password = mutableStateOf("789012")
        private set

    var displayText = mutableStateOf("")
        private set

    fun onLoginInputChange(login: String) {
        this.login.value = login
    }

    fun onPasswordInputChange(password: String) {
        this.password.value = password
    }

    fun authButtonClick() {
        screenModelScope.launch(Dispatchers.Default) {
            val response = repo.auth(
                mapOf(
                    "login" to login.value.trim(),
                    "password" to password.value.trim()
                )
            )

            when (response) {
                ResponseState.ClientError -> {
                    displayText.value = "Client error"
                }

                ResponseState.Redirect -> {
                    displayText.value = "Redirect"
                }

                ResponseState.ServerError -> {
                    displayText.value = "Server error"
                }

                ResponseState.Success -> {
                    displayText.value = "Success"
                }

                ResponseState.UnknownError -> {
                    displayText.value = "Unknown error"
                }

                ResponseState.WrongCredentials -> {
                    displayText.value = "Wrong credentials"
                }

                ResponseState.WrongPassword -> {
                    displayText.value = "Wrong password"
                }

                ResponseState.BadRequest ->{
                   displayText.value = "Bad request"
                }
            }
        }
    }
}