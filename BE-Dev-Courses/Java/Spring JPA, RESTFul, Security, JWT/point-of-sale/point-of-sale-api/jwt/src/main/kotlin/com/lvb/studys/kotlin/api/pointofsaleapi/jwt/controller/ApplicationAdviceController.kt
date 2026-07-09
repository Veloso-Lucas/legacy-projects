package com.lvb.studys.kotlin.api.pointofsaleapi.jwt.controller

import com.lvb.studys.kotlin.api.pointofsaleapi.jwt.dto.ResponseDTO
import com.lvb.studys.kotlin.api.pointofsaleapi.jwt.exceptions.InvalidOperationException
import com.lvb.studys.kotlin.api.pointofsaleapi.jwt.exceptions.LoginNotFoundException
import com.lvb.studys.kotlin.api.pointofsaleapi.jwt.exceptions.NoItemException
import com.lvb.studys.kotlin.api.pointofsaleapi.jwt.exceptions.PasswordNotFoundException
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

    @ExceptionHandler(LoginNotFoundException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleLoginNotFoundException(e: LoginNotFoundException): ResponseDTO {
        val messageError = e.message ?: ""
        return ResponseDTO(messageError)
    }

    @ExceptionHandler(PasswordNotFoundException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handlePasswordNotFoundException(e: PasswordNotFoundException): ResponseDTO {
        val messageError = e.message ?: ""
        return ResponseDTO(messageError)
    }
}