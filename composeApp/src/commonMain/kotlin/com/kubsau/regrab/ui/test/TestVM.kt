package com.kubsau.regrab.ui.test

import androidx.compose.runtime.mutableStateOf
import com.kubsau.regrab.network.NetworkRepo
import com.kubsau.regrab.network.models.request.AuthRequest
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.launch

class TestVM(val repo: NetworkRepo) : ViewModel() {
    var responce = mutableStateOf("")
        private set

    var login = mutableStateOf("")
        private set

    var password = mutableStateOf("")
        private set

    private fun getDocs() {
        viewModelScope.launch {
            responce.value = repo.getDocs()
        }
    }

    fun addLogin(login: String) {
        this.login.value = login
    }

    fun addPassword(password: String) {
        this.password.value = password
    }

    fun auth() {
        viewModelScope.launch {
            responce.value =
                repo.auth(AuthRequest(login = login.value.trim(), password = password.value.trim()))
                    .toString()
        }
    }

    init {
        getDocs()
    }
}