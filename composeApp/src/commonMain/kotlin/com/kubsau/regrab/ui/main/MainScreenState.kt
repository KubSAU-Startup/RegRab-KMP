package com.kubsau.regrab.ui.main

data class MainScreenState(
    val token: String = ""
) {
    companion object {
        val EMPTY = MainScreenState()
    }
}
