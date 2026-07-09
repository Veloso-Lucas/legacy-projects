package com.lvb.studys.kotlin.api.wsuserlogin.entity

import com.lvb.studys.kotlin.api.wsuserlogin.dto.UserDTO
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import java.io.Serializable

@Document
data class User(

    @Id
    var id: String? = null,
    var firstName: String = "",
    var lastName: String = "",
    var email: String = "",

    @DBRef(lazy = true) //the referenced documents will not be loaded until they are accessed first
    var roles: List<Role> = ArrayList()

) : Serializable {

    //TODO remove this and create a generic converter for entity to DTO/ DTO to entity
    constructor(userDTO: UserDTO) : this() {
        this.id = userDTO.id
        this.firstName = userDTO.firstName.toString()
        this.lastName = userDTO.lastName.toString()
        this.email = userDTO.email.toString()
        this.roles = userDTO.roles
    }
}
