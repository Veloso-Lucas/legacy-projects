package com.lvb.studys.kotlin.api.wsuserlogin.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
@EnableWebSecurity
class WebSecurityConfiguration  {

    @Bean
    fun encoder(): PasswordEncoder? { // Create a bean to BCryptPasswordEncoder to we can encode/decode the user's password
        return BCryptPasswordEncoder()
    }
}