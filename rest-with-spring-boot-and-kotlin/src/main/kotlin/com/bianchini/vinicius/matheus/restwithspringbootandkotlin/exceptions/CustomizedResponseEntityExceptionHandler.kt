package com.bianchini.vinicius.matheus.restwithspringbootandkotlin.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*

@ControllerAdvice
@RestController
class CustomizedResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(Exception::class)
    fun handleAllException(
        ex: Exception,
        request: WebRequest
    ) = ResponseEntity(
        ExceptionResponse(
            Date(),
            ex.message,
            request.getDescription(false)
        ),
        HttpStatus.INTERNAL_SERVER_ERROR
    )

    @ExceptionHandler(UnsupportedMethodOperationException::class)
    fun handleBadRequestException(
        ex: Exception,
        request: WebRequest
    ) = ResponseEntity(
        ExceptionResponse(
            Date(),
            ex.message,
            request.getDescription(false)
        ),
        HttpStatus.INTERNAL_SERVER_ERROR
    )
}