package com.lvb.studys.kotlin.api.pointofsaleapi.jwt.dto

data class UserDTO(
    var id: Long? = null,
    var name: String,
    var isEnable: Boolean? = false
)
