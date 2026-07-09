package com.lvb.studies.kotlin.api.dto

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude
data class CarPostDTO(

    val model: String = "",
    val brand: String = "",
    val price: Double = 0.0,
    val description: String = "",
    val engineVersion: String = "",
    val city: String = "",
    val createdDate: String = "",
    val ownerId: Long = 0,
    val ownerName: String = "",
    val ownerType: String = "",
    val contact: String = ""
)
