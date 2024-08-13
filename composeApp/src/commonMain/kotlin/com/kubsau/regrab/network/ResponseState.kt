package com.kubsau.regrab.network

sealed class ResponseState {
    data object Success : ResponseState()
    data object Redirect : ResponseState()
    data object ClientError : ResponseState()
    data object ServerError : ResponseState()
    data object UnknownError : ResponseState()
    data object BadRequest : ResponseState()

    data object WrongCredentials : ResponseState()
    data object WrongPassword : ResponseState()
}