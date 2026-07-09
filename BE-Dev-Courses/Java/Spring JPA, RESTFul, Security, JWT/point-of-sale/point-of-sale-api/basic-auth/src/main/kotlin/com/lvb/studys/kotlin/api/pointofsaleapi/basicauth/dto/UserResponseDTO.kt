package com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.dto

data class UserResponseDTO (
    var id: Long? = null,
    var name: String,
    var isEnable: Boolean? = false,
    var username: String
)