package com.lvb.studys.kotlin.api.wsuserlogin.service.user

import com.lvb.studys.kotlin.api.wsuserlogin.dto.UserDTO
import com.lvb.studys.kotlin.api.wsuserlogin.entity.User
import com.lvb.studys.kotlin.api.wsuserlogin.exception.user.UserNotFoundException
import com.lvb.studys.kotlin.api.wsuserlogin.repository.IUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl @Autowired constructor(
    private val iUserRepository: IUserRepository
) : IUserService {

    override fun findAll(): List<User> {
        return iUserRepository.findAll()
    }

    override fun findById(id: String): User {
        val user = iUserRepository.findById(id)

        return user.orElseThrow { UserNotFoundException() }
    }

    override fun createUser(userDTO: UserDTO): User {
        return iUserRepository.save(User(userDTO))
    }

    override fun updateUser(userDTO: UserDTO): User {
        userDTO.id?.let { findById(it) }

        return iUserRepository.save(User(userDTO))
    }

    override fun removeUser(id: String) {
        val user = findById(id)
        iUserRepository.delete(user)
    }

}