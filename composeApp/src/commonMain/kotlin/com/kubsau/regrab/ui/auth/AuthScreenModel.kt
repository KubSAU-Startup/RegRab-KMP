package com.kubsau.regrab.ui.auth

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.kubsau.regrab.network.NetworkRepo
import com.kubsau.regrab.network.ResponseState
import com.kubsau.regrab.storage.AccountStorage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AuthScreenModel(
    private val repo: NetworkRepo,
    private val storage: AccountStorage
) : ScreenModel {

    val screenState = MutableStateFlow(AuthScreenState.EMPTY)

    fun onLoginInputChange(login: String) {
        val newValue = screenState.value.copy(
            login = login,
            showWrongCredentialsError = false
        )

        screenState.update { newValue }
    }

    fun onPasswordInputChange(password: String) {
        val newValue = screenState.value.copy(
            password = password,
            showWrongCredentialsError = false
        )

        screenState.update { newValue }
    }

    fun authButtonClick() {
        screenModelScope.launch(Dispatchers.Default) {
            val response = repo.auth(
                mapOf(
                    "login" to screenState.value.login.trim(),
                    "password" to screenState.value.password.trim()
                )
            )

            when (response) {
                ResponseState.ClientError -> {
                    val newState = screenState.value.copy(
                        displayText = "Client error"
                    )

                    screenState.update { newState }
                }

                ResponseState.Redirect -> {
                    val newState = screenState.value.copy(
                        displayText = "Redirect"
                    )

                    screenState.update { newState }
                }

                ResponseState.ServerError -> {
                    val newState = screenState.value.copy(
                        displayText = "Server error"
                    )

                    screenState.update { newState }
                }

                ResponseState.Success -> {
                    val newState = screenState.value.copy(
                        enableNavigation = true
                    )

                    screenState.update { newState }
                }

                ResponseState.UnknownError -> {
                    val newState = screenState.value.copy(
                        displayText = "Unknown error"
                    )

                    screenState.update { newState }
                }

                ResponseState.WrongCredentials -> {
                    val newState = screenState.value.copy(
                        displayText = "Wrong credentials"
                    )

                    screenState.update { newState }
                }

                ResponseState.WrongPassword -> {
                    val newState = screenState.value.copy(
                        displayText = "Wrong password"
                    )

                    screenState.update { newState }
                }

                ResponseState.BadRequest -> {
                    val newState = screenState.value.copy(
                        displayText = "Bad request"
                    )

                    screenState.update { newState }
                }
            }
        }
    }
}