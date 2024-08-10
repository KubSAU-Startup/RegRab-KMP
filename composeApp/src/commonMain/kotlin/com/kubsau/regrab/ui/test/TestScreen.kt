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
import org.koin.compose.koinInject

@Composable
fun TestScreen(
    viewModel: TestVM = koinInject()
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Text(
                text = viewModel.responce.value
            )
        }
        Column {
            TextField(
                value = viewModel.login.value,
                onValueChange = viewModel::addLogin
            )

            TextField(
                value = viewModel.password.value,
                onValueChange = viewModel::addPassword
            )

            Button(
                onClick = {
                    viewModel.auth()
                }
            ) {
                Text(text = "auth")
            }
        }
    }
}