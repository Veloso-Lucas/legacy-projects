package com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.controller

import com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.dto.ResponseDTO
import com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.exceptions.InvalidOperationException
import com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.exceptions.NoItemException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ApplicationAdviceController {

    @ExceptionHandler(NoItemException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleNoItemException(e: NoItemException): ResponseDTO {
        val messageError = e.message ?: ""
        return ResponseDTO(messageError)
    }

    @ExceptionHandler(InvalidOperationException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleInvalidOperationException(e: InvalidOperationException): ResponseDTO {
        val messageError = e.message ?: ""
        return ResponseDTO(messageError)
    }
}