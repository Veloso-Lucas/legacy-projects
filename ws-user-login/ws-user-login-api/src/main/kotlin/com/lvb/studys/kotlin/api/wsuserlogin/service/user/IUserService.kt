package com.lvb.studys.kotlin.api.wsuserlogin.service.user

import com.lvb.studys.kotlin.api.wsuserlogin.dto.UserDTO
import com.lvb.studys.kotlin.api.wsuserlogin.entity.User
import org.springframework.stereotype.Service

@Service
interface IUserService  {

    fun findAll(): List<User>

    fun findById(id: String) : User

    fun createUser(userDTO: UserDTO) : User

    fun updateUser(userDTO: UserDTO) : User

    fun removeUser(id: String)
}