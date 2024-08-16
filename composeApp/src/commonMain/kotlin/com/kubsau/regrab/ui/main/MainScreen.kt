package com.kubsau.regrab.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.kubsau.regrab.ui.auth.AuthScreen
import com.kubsau.regrab.ui.test.TestScreen
import org.koin.compose.koinInject

class MainScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val screenModel = koinInject<MainScreenModel>()
        val screenState by screenModel.screenState.collectAsState()

        if (screenState.token == "")
            navigator.push(AuthScreen())
        else navigator.push(TestScreen())
    }
}