package com.lvb.studys.kotlin.api.pointofsaleapi.controller

import com.lvb.studys.kotlin.api.pointofsaleapi.dto.ResponseDTO
import com.lvb.studys.kotlin.api.pointofsaleapi.dto.UserDTO
import com.lvb.studys.kotlin.api.pointofsaleapi.entity.User
import com.lvb.studys.kotlin.api.pointofsaleapi.exceptions.InvalidOperationException
import com.lvb.studys.kotlin.api.pointofsaleapi.exceptions.NoItemException
import com.lvb.studys.kotlin.api.pointofsaleapi.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController @Autowired constructor(
    private val userService: UserService
) {

    @GetMapping
    fun getAll(): ResponseEntity<List<UserDTO>> {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers())
    }

    @PostMapping
    fun saveUser(@RequestBody user: UserDTO): ResponseEntity<Any> {
        user.isEnabled = true
        userService.saveUser(user)
        return try {
            ResponseEntity(HttpStatus.CREATED)
        } catch (e: Exception) {
            ResponseEntity(e.message, HttpStatus.CREATED)
        }
    }

    @PutMapping
    fun updateUser(@RequestBody user : UserDTO) : ResponseEntity<Any> {
        if (user.id == null) {
            throw InvalidOperationException("User's ID need to be informed")
        }

        return try {
            ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(user))
        } catch (e: NoItemException) {
            ResponseEntity(ResponseDTO(e.message ?: ""), HttpStatus.BAD_REQUEST)
        } catch (e: Exception) {
            ResponseEntity(ResponseDTO(e.message ?: ""), HttpStatus.INTERNAL_SERVER_ERROR)
        }

    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable("id") id: Long): ResponseEntity<Any> {
        return try {
            userService.deleteUser(id)
            ResponseEntity.status(HttpStatus.OK).body(ResponseDTO("User deleted successfully"))
        } catch (e: EmptyResultDataAccessException) {
            ResponseEntity(ResponseDTO("User not found"), HttpStatus.INTERNAL_SERVER_ERROR)
        } catch (e: Exception) {
            ResponseEntity(e.message, HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}