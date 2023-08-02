package com.bianchini.vinicius.matheus.restwithspringbootandkotlin.utils.extensions

fun String.toGlobalNumber() = this.replace(",", ".").toDouble()
