package com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.dto

data class ResponseDTO(

    val messages: List<String>
) {
    constructor(messages: String) : this(listOf(messages))
}


