package com.kubsau.regrab.ui.test

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel

class TestScreen : Screen {

    @Composable
    override fun Content() {
        val state = koinScreenModel<TestScreenModel>()
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Text(
                    text = state.response.value
                )
            }
            Column {
                TextField(
                    value = state.login.value,
                    onValueChange = state::addLogin
                )

                TextField(
                    value = state.password.value,
                    onValueChange = state::addPassword
                )

                Button(
                    onClick = state::auth
                ) {
                    Text(text = "auth")
                }
            }
        }
    }
}