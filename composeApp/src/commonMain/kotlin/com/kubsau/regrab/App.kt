package com.kubsau.regrab

import androidx.compose.runtime.Composable
import com.kubsau.regrab.di.navigationModule
import com.kubsau.regrab.di.networkModule
import com.kubsau.regrab.di.viewmodelModule
import com.kubsau.regrab.theme.AppTheme
import com.kubsau.regrab.ui.test.TestScreen
import org.koin.compose.KoinApplication

@Composable
internal fun App() = AppTheme {
    KoinApplication(application = {
        modules(networkModule, viewmodelModule, navigationModule)
    }) {
        TestScreen()
    }
}
