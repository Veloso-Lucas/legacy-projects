package com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.service

import com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.dto.UserDTO
import com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.dto.UserResponseDTO
import com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.entity.User
import com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.exceptions.NoItemException
import com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.repository.UserRepository
import com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.security.SecurityConfig
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService @Autowired constructor(
    private val userRepository: UserRepository
) {

    private var modelMapper: ModelMapper = ModelMapper()

    fun getAllUsers(): List<UserResponseDTO> {
        return userRepository.findAll().map {
            UserResponseDTO(it.id, it.name, it.isEnabled, it.username)
        }.toList()
    }

    fun findUserById(id: Long): UserDTO {
        val user = userRepository.findById(id)

        if (user.isEmpty) {
            throw NoItemException("User not found")
        }

        return UserDTO(user.get().id, user.get().name, user.get().isEnabled, user.get().username, user.get().password)

    }


    fun saveUser(user: UserDTO): UserDTO {
        val newUser = modelMapper.map(user, User::class.java)

        newUser.isEnabled = true
        newUser.password = SecurityConfig.passwordEncoder().encode(user.password)

        userRepository.save(newUser)
        return UserDTO(newUser.id, newUser.name, newUser.isEnabled, newUser.username, newUser.password)
    }

    fun updateUser(user: UserDTO): UserDTO {
        findUserById(user.id!!)

        val userToUpdate = modelMapper.map(user, User::class.java)
        userToUpdate.password = SecurityConfig.passwordEncoder().encode(user.password)

        userRepository.save(userToUpdate)
        return user
    }

    fun deleteUser(id: Long) {
        userRepository.deleteById(id)
    }

    fun getByUsername(username: String) : User = userRepository.findUserByUsername(username)
}