package com.kubsau.regrab.ui.test

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.kubsau.regrab.storage.AccountStorage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TestScreenModel(
    private val storage: AccountStorage
) : ScreenModel {
    val screenState = MutableStateFlow(TestScreenState.EMPTY)

    init {
        screenModelScope.launch {
            screenState.update {
                screenState.value.copy(
                    displayText = storage.getToken()
                )
            }
        }
    }
}