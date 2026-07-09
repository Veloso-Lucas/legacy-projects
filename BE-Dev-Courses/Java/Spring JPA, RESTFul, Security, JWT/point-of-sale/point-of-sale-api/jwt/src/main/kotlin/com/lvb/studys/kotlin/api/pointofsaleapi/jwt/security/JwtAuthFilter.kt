package com.lvb.studys.kotlin.api.pointofsaleapi.jwt.security

import com.fasterxml.jackson.databind.ObjectMapper
import com.lvb.studys.kotlin.api.pointofsaleapi.jwt.dto.ResponseDTO
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.web.filter.OncePerRequestFilter
import java.lang.RuntimeException

class JwtAuthFilter(
    private val jwtService: JwtService,
    private val userDetailService: CustomUserDetailService

) : OncePerRequestFilter() {


    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {

        try {
            val authorization = request.getHeader("Authorization")

            if (authorization != null && authorization.startsWith("Bearer")) {

                val token = authorization.split(" ")[1]
                val username = jwtService.getUsername(token)

                val user = userDetailService.loadUserByUsername(username)

                //Create a user that will be inserted in spring security context
                val userCtx = UsernamePasswordAuthenticationToken(user, null, user.authorities)

                // Configuring spring security with a web authentication
                userCtx.details = WebAuthenticationDetailsSource().buildDetails(request)

                SecurityContextHolder.getContext().authentication = userCtx
            }

            filterChain.doFilter(request, response)
        }
        catch (e: RuntimeException) {
            response.status = HttpStatus.UNAUTHORIZED.value()
            response.contentType = MediaType.APPLICATION_JSON_VALUE
            response.writer.write(convertObjectToJson(ResponseDTO("Invalid Token!!")))
        }

    }

    private fun convertObjectToJson(responseDTO: ResponseDTO): String {
        val mapper = ObjectMapper()
        return mapper.writeValueAsString(responseDTO)
    }

}