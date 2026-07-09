package com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.dto

data class UserDTO(
    var id: Long? = null,
    var name: String,
    var isEnable: Boolean? = false,
    var username: String,
    var password: String
)
