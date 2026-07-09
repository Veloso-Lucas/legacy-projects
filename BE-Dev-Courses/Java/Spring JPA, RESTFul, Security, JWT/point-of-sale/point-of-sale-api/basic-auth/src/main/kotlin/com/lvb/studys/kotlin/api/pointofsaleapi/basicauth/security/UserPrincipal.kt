package com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.security

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserPrincipal(private val username: String, private val password: String) : UserDetails {

    private var authorities: MutableCollection<out GrantedAuthority> = arrayListOf()

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = authorities

    override fun getPassword(): String = this.password

    override fun getUsername(): String = this.username

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true
}