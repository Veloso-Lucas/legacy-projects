package com.lvb.studys.kotlin.api.pointofsaleapi.jwt.service

import com.lvb.studys.kotlin.api.pointofsaleapi.jwt.dto.UserDTO
import com.lvb.studys.kotlin.api.pointofsaleapi.jwt.entity.User
import com.lvb.studys.kotlin.api.pointofsaleapi.jwt.exceptions.NoItemException
import com.lvb.studys.kotlin.api.pointofsaleapi.jwt.repository.UserRepository
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService @Autowired constructor(
    private val userRepository: UserRepository
) {

    private val modelMapper =  ModelMapper()

    fun getAllUsers(): List<UserDTO> {

        ModelMapper()
        return userRepository.findAll().map {
            UserDTO(it.id, it.name, it.isEnabled)
        }.toList()
    }

    fun findUserById(id: Long): UserDTO {
        val user = userRepository.findById(id)

        if (user.isEmpty) {
            throw NoItemException("User not found")
        }

        return UserDTO(user.get().id, user.get().name, user.get().isEnabled)

    }


    fun saveUser(user: UserDTO): UserDTO {
        val newUser = modelMapper.map(user, User::class.java)
        userRepository.save(newUser)
        return UserDTO(newUser.id, newUser.name, newUser.isEnabled)
    }

    fun updateUser(user: UserDTO): UserDTO {
        findUserById(user.id!!)

        val userToUpdate = modelMapper.map(user, User::class.java)

        userRepository.save(userToUpdate)
        return user
    }

    fun deleteUser(id: Long) {
        userRepository.deleteById(id)
    }

    fun getByUsername(username: String) : User = userRepository.findUserByUsername(username)
}