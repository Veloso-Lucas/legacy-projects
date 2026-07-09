package com.lvb.studys.kotlin.api.wsuserlogin.dto


import com.lvb.studys.kotlin.api.wsuserlogin.entity.Role
import com.lvb.studys.kotlin.api.wsuserlogin.entity.User
import java.io.Serializable

data class UserDTO(

    var id: String? = null,

    var firstName: String? = null,

    var lastName: String? = null,

    var email: String? = null,

    var roles: List<Role> = ArrayList()

) : Serializable {

    //TODO remove this and create a generic converter for entity to DTO/ DTO to entity
    constructor(user: User) : this() {
        this.id = user.id
        this.firstName = user.firstName
        this.lastName = user.lastName
        this.email = user.email
        this.roles = user.roles
    }
}

