package com.bianchini.vinicius.matheus.restwithspringbootandkotlin.exceptions

import java.util.*

data class ExceptionResponse(
    val timestamp: Date,
    val message: String?,
    val details: String
)