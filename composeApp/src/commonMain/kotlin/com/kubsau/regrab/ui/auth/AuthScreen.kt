package com.kubsau.regrab.ui.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.kubsau.regrab.ui.test.TestScreen

class AuthScreen : Screen {
    @Composable
    override fun Content() {
        val screenModel = koinScreenModel<AuthScreenModel>()
        val screenState by screenModel.screenState.collectAsState()
        val navigator = LocalNavigator.currentOrThrow

        if (screenState.enableNavigation) {
            navigator.push(TestScreen())
        }

        Scaffold { padding ->
            Column(
                modifier = Modifier.fillMaxSize().padding(padding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = screenState.displayText)
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(.8f),
                    value = screenState.login,
                    onValueChange = screenModel::onLoginInputChange,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    )
                )

                Spacer(modifier = Modifier.height(4.dp))

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(.8f),
                    value = screenState.password,
                    onValueChange = screenModel::onPasswordInputChange,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Go
                    ),
                    keyboardActions = KeyboardActions(
                        onGo = {
                            screenModel.authButtonClick()
                        }
                    ),
                )

                Spacer(modifier = Modifier.height(4.dp))

                Button(onClick = screenModel::authButtonClick) {
                    Text(text = "Auth")
                }
            }
        }
    }
}