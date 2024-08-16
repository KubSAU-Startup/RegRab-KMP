package com.kubsau.regrab

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.kubsau.regrab.di.appModule
import com.kubsau.regrab.theme.AppTheme
import com.kubsau.regrab.ui.main.MainScreen
import me.sujanpoudel.utils.paths.appDataDirectory
import org.koin.compose.KoinApplication

var appDir = appDataDirectory("com.kubsau.regrab")

@Composable
internal fun App() = AppTheme {
    KoinApplication(application = {
        modules(appModule)
    }) {
        Navigator(MainScreen())
    }
}

