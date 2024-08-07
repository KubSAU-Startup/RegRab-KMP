package com.kubsau.regrab

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.kubsau.regrab.di.networkModule
import regrab.composeapp.generated.resources.*
import com.kubsau.regrab.theme.AppTheme
import com.kubsau.regrab.theme.LocalThemeIsDark
import com.kubsau.regrab.ui.StandardScreen
import kotlinx.coroutines.isActive
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import org.koin.compose.KoinApplication

@Composable
internal fun App() = AppTheme {
    KoinApplication(application = {
        modules(networkModule)
    }){
        StandardScreen()
    }
}
