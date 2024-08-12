package com.kubsau.regrab.ui.test

import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.kubsau.regrab.network.NetworkRepo
import kotlinx.coroutines.launch

class TestScreenModel(
    private val repo: NetworkRepo
) : ScreenModel {
    var login = mutableStateOf("")
        private set

    var password = mutableStateOf("")
        private set

    var response = mutableStateOf("")
        private set

    fun addLogin(login: String) {
        this.login.value = login
    }

    fun addPassword(password: String) {
        this.password.value = password
    }

    private fun getDocs() {
        screenModelScope.launch {
            response.value = repo.getDocs()
        }
    }

    fun auth() {
        screenModelScope.launch {
            response.value =
                repo.auth(
                    mapOf(
                        "login" to login.value.trim(),
                        "password" to password.value.trim()
                    )
                ).toString()
        }
    }

    init {
        getDocs()
    }
}