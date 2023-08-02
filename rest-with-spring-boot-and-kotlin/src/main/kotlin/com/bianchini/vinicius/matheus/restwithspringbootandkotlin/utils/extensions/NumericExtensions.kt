package com.bianchini.vinicius.matheus.restwithspringbootandkotlin.utils.extensions

fun isNumeric(value: String): Boolean {
    return value.matches("""[-+]?[0-9]*\.?[0-9]+""".toRegex())
}