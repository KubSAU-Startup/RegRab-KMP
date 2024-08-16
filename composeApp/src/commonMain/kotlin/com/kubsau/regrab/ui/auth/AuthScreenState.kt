package com.kubsau.regrab.ui.auth

data class AuthScreenState(
    val login: String,
    val password: String,
    val displayText: String,
    val isLoading: Boolean,
    val isPasswordVisible: Boolean,
    val showAuthError: Boolean,
    val showWrongAccountTypeError: Boolean,
    val showWrongCredentialsError: Boolean,
    val enableNavigation: Boolean
) {
    companion object {
        val EMPTY = AuthScreenState(
            login = "",
            password = "",
            displayText = "",
            isLoading = false,
            isPasswordVisible = false,
            showAuthError = false,
            showWrongAccountTypeError = false,
            showWrongCredentialsError = false,
            enableNavigation = false
        )
    }
}
