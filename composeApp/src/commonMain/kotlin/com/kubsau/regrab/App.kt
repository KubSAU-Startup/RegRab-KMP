package com.kubsau.regrab

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.kubsau.regrab.di.navigationModule
import com.kubsau.regrab.di.networkModule
import com.kubsau.regrab.di.screenModelModule
import com.kubsau.regrab.theme.AppTheme
import com.kubsau.regrab.ui.auth.AuthScreen
import org.koin.compose.KoinApplication

@Composable
internal fun App() = AppTheme {
    KoinApplication(application = {
        modules(
            networkModule,
            navigationModule,
            screenModelModule
        )
    }) {
        Navigator(AuthScreen())
    }
}
