package com.lvb.studys.kotlin.api.pointofsaleapi.controller

import com.lvb.studys.kotlin.api.pointofsaleapi.dto.ResponseDTO
import com.lvb.studys.kotlin.api.pointofsaleapi.exceptions.InvalidOperationException
import com.lvb.studys.kotlin.api.pointofsaleapi.exceptions.NoItemException
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