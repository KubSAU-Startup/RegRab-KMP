package com.kubsau.regrab.network.models

import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    val response: T?,
    val error: ErrorResponse? = null,
    val success: Boolean
)
