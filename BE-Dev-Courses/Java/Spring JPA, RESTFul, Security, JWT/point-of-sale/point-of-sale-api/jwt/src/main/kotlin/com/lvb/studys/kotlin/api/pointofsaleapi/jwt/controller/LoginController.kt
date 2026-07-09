package com.lvb.studys.kotlin.api.pointofsaleapi.jwt.controller

import com.lvb.studys.kotlin.api.pointofsaleapi.jwt.dto.LoginDTO
import com.lvb.studys.kotlin.api.pointofsaleapi.jwt.dto.ResponseDTO
import com.lvb.studys.kotlin.api.pointofsaleapi.jwt.dto.TokenDTO
import com.lvb.studys.kotlin.api.pointofsaleapi.jwt.security.CustomUserDetailService
import com.lvb.studys.kotlin.api.pointofsaleapi.jwt.security.JwtService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/login")
class LoginController @Autowired constructor(
    private val customUserDetailService: CustomUserDetailService,
    private val jwtService: JwtService,

    @Value("\${security.jwt.expiration}")
    val expiration: Int,
){

    @PostMapping
    fun post(@RequestBody loginDTO: LoginDTO): ResponseEntity<Any> {
        return try {
            // verify if credentials are valid
            customUserDetailService.verifyUserCredentials(loginDTO)
            // Generate Token
            val token = jwtService.generateToken(loginDTO.username)
            ResponseEntity(TokenDTO(token, expiration), HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(ResponseDTO(e.message ?: ""), HttpStatus.UNAUTHORIZED)
        }
    }
}