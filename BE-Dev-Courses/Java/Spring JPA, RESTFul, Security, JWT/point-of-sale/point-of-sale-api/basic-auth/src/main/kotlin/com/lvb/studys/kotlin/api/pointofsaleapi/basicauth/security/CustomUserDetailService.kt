package com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.security

import com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.entity.User
import com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class CustomUserDetailService @Autowired constructor(
    private val userService: UserService
): UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {

        var user: User? = null
        username?.let {
            user = userService.getByUsername(it)
        }
        return UserPrincipal(user?.username ?: "", user?.password ?: "")
    }

}