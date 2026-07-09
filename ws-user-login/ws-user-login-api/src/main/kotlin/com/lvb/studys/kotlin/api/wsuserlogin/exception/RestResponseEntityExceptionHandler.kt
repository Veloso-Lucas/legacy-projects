package com.lvb.studys.kotlin.api.wsuserlogin.exception

import com.lvb.studys.kotlin.api.wsuserlogin.exception.user.UserNotFoundException
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice // Ths annotation makes this class handler with every exception in controllers
class RestResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(UserNotFoundException::class)
    fun userNotFound(e : UserNotFoundException, request: HttpServletRequest) : ResponseEntity<StandardError>{
        val status = HttpStatus.NOT_FOUND
        val err = StandardError(
            timeStamp = System.currentTimeMillis(),
            status = status.value(),
            "Not Found",
            e.message ?: "Not Found",
            request.requestURI
        )
        return ResponseEntity.status(status).body(err)
    }
}