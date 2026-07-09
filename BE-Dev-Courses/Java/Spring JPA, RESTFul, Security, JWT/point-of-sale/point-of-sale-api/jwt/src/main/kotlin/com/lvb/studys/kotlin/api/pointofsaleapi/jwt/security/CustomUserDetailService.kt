package com.lvb.studys.kotlin.api.pointofsaleapi.jwt.security

import com.lvb.studys.kotlin.api.pointofsaleapi.jwt.dto.LoginDTO
import com.lvb.studys.kotlin.api.pointofsaleapi.jwt.entity.User
import com.lvb.studys.kotlin.api.pointofsaleapi.jwt.exceptions.LoginNotFoundException
import com.lvb.studys.kotlin.api.pointofsaleapi.jwt.exceptions.PasswordNotFoundException
import com.lvb.studys.kotlin.api.pointofsaleapi.jwt.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class CustomUserDetailService @Autowired constructor(
    private val userService: UserService
) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {

        var user: User? = null
        username?.let {
            user = userService.getByUsername(it)
        }

        if (user == null) {
            throw LoginNotFoundException("Login invalid!!")

        }

        return UserPrincipal(user?.username ?: "", user?.password ?: "")
    }


    fun verifyUserCredentials(login: LoginDTO) {
        val user = loadUserByUsername(login.username)

        val passwordIsSame = SecurityConfig.passwordEncoder().matches(login.password, user.password)

        if (!passwordIsSame)
            throw PasswordNotFoundException("Password invalid!!")


    }

}