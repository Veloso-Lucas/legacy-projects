package com.lvb.studys.kotlin.api.pointofsaleapi.dto

data class ResponseDTO(

    val messages: List<String>
) {
    constructor(messages: String) : this(listOf(messages))
}


