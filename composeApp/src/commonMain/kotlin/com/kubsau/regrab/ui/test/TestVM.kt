package com.kubsau.regrab.ui.test

import androidx.compose.runtime.mutableStateOf
import com.kubsau.regrab.network.NetworkRepo
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.launch

class TestVM(val repo: NetworkRepo) : ViewModel() {
    var responce = mutableStateOf("")
        private set

    private fun getDocs() {
        viewModelScope.launch {
            responce.value = repo.getDocs()
        }
    }

    init {
        getDocs()
    }
}