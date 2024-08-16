package com.kubsau.regrab.ui.test

data class TestScreenState(
    val displayText: String = ""
) {
    companion object {
        val EMPTY = TestScreenState()
    }
}
