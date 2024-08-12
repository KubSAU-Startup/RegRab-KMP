package com.kubsau.regrab.ui.auth

import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.kubsau.regrab.network.NetworkRepo
import kotlinx.coroutines.launch

class AuthScreenModel(
    private val repo: NetworkRepo
) : ScreenModel {
    var login = mutableStateOf("")
        private set

    var password = mutableStateOf("")
        private set

    fun onLoginInputChange(login: String) {
        this.login.value = login
    }

    fun onPasswordInputChange(password: String) {
        this.password.value = password
    }

    fun auth() {
        screenModelScope.launch {
            repo.auth(
                mapOf(
                    "login" to login.value.trim(),
                    "password" to password.value.trim()
                )
            )
        }
    }
}