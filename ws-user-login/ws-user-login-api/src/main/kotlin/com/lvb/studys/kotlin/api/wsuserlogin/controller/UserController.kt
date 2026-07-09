package com.lvb.studys.kotlin.api.wsuserlogin.controller

import com.lvb.studys.kotlin.api.wsuserlogin.dto.UserDTO
import com.lvb.studys.kotlin.api.wsuserlogin.entity.Role
import com.lvb.studys.kotlin.api.wsuserlogin.service.user.IUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class UserController @Autowired constructor(
    private val iUserService: IUserService
) {

    @GetMapping("/users")
    fun findAll(): ResponseEntity<List<UserDTO>> {

        val usersDTO = iUserService.findAll().map { user -> UserDTO(user) }
        return ResponseEntity.status(HttpStatus.OK).body(usersDTO)
    }

    @GetMapping("/user/{id}")
    fun findById(@PathVariable("id") id: String): ResponseEntity<UserDTO> {

        val userDTO = UserDTO(iUserService.findById(id))
        return ResponseEntity.status(HttpStatus.OK).body(userDTO)
    }

    @GetMapping("/user/{id}/roles")
    fun findUserRoles(@PathVariable("id") id: String): ResponseEntity<List<Role>> {

        val userDTO = UserDTO(iUserService.findById(id))
        return ResponseEntity.status(HttpStatus.OK).body(userDTO.roles)
    }

    @PostMapping("/user")
    fun save(@RequestBody userDTO: UserDTO): ResponseEntity<UserDTO> {

        val createdUserDTO = UserDTO(iUserService.createUser(userDTO))
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserDTO)
    }

    @PutMapping("/user/{id}")
    fun update(@PathVariable("id") id: String, @RequestBody userDTO: UserDTO): ResponseEntity<UserDTO> {
        userDTO.id = id
        val createdUserDTO = UserDTO(iUserService.updateUser(userDTO))
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserDTO)
    }

    @DeleteMapping("/user/{id}")
    fun delete(@PathVariable("id") id: String): ResponseEntity<Any> {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(iUserService.removeUser(id))
    }

}