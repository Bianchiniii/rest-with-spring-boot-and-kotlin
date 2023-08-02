package com.bianchini.vinicius.matheus.restwithspringbootandkotlin

import com.bianchini.vinicius.matheus.restwithspringbootandkotlin.exceptions.ExceptionResponse
import com.bianchini.vinicius.matheus.restwithspringbootandkotlin.exceptions.UnsupportedMethodOperationException
import com.bianchini.vinicius.matheus.restwithspringbootandkotlin.utils.extensions.isNumeric
import com.bianchini.vinicius.matheus.restwithspringbootandkotlin.utils.extensions.toGlobalNumber
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.service.invoker.PathVariableArgumentResolver
import java.util.concurrent.atomic.AtomicLong
import kotlin.math.pow

@RestController
class MathController {

    val counter = AtomicLong()

    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(
        @PathVariable(value = "numberOne") numberOne: String,
        @PathVariable(value = "numberTwo") numberTwo: String
    ): Double {
        if (!isNumeric(numberOne) or !isNumeric(numberTwo))
            throw UnsupportedMethodOperationException("Invalid value, set numeric value!")
        return numberOne.toGlobalNumber().plus(numberTwo.toGlobalNumber())
    }

    @RequestMapping(value = ["/subtraction/{numberOne}/{numberTwo}"])
    fun subtraction(
        @PathVariable(value = "numberOne") numberOne: String,
        @PathVariable(value = "numberTwo") numberTwo: String
    ): Double {
        if (!isNumeric(numberOne) or !isNumeric(numberTwo))
            throw UnsupportedMethodOperationException("Invalid value, set numeric value!")
        return numberOne.toGlobalNumber().minus(numberTwo.toGlobalNumber())
    }

    @RequestMapping(value = ["/division/{numberOne}/{numberTwo}"])
    fun division(
        @PathVariable(value = "numberOne") numberOne: String,
        @PathVariable(value = "numberTwo") numberTwo: String
    ): Double {
        if (!isNumeric(numberOne) or !isNumeric(numberTwo))
            throw UnsupportedMethodOperationException("Invalid value, set numeric value!")
        return numberOne.toGlobalNumber().div(numberTwo.toGlobalNumber())
    }

    @RequestMapping(value = ["/multiplication/{numberOne}/{numberTwo}"])
    fun multiplication(
        @PathVariable(value = "numberOne") numberOne: String,
        @PathVariable(value = "numberTwo") numberTwo: String
    ): Double {
        if (!isNumeric(numberOne) or !isNumeric(numberTwo))
            throw UnsupportedMethodOperationException("Invalid value, set numeric value!")
        return numberOne.toGlobalNumber() * (numberTwo.toGlobalNumber())
    }

    @RequestMapping(value = ["/mean/{numberOne}/{numberTwo}"])
    fun mean(
        @PathVariable(value = "numberOne") numberOne: String,
        @PathVariable(value = "numberTwo") numberTwo: String
    ): Double {
        if (!isNumeric(numberOne) or !isNumeric(numberTwo))
            throw UnsupportedMethodOperationException("Invalid value, set numeric value!")
        return (numberOne.toGlobalNumber().plus(numberTwo.toGlobalNumber())).div(2)
    }

    @RequestMapping(value = ["/sqrt/{number}"])
    fun sqrt(
        @PathVariable(value = "number") numberOne: String,
    ): Double {
        if (!isNumeric(numberOne))
            throw UnsupportedMethodOperationException("Invalid value, set numeric value!")
        return kotlin.math.sqrt(numberOne.toGlobalNumber())
    }
}