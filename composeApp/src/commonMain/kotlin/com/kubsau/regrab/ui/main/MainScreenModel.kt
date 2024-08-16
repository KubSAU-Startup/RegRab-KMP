package com.kubsau.regrab.ui.main

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.kubsau.regrab.storage.AccountStorage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainScreenModel(
    private val storage: AccountStorage
) : ScreenModel {
    val screenState = MutableStateFlow(MainScreenState.EMPTY)

    init {
        screenModelScope.launch {
            screenState.update {
                screenState.value.copy(
                    token = storage.getToken()
                )
            }
        }
    }
}