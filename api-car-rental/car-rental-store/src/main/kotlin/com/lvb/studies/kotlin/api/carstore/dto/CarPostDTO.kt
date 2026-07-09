package com.lvb.studies.kotlin.api.carstore.dto

import com.fasterxml.jackson.annotation.JsonInclude
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude
data class CarPostDTO(

    val model: String = "",
    val brand: String = "",
    val price: String = "",
    val description: String = "",
    val engineVersion: String = "",
    val city: String = "",
    val createdDate: String = "",
    val ownerId: Long = 0,
    val ownerName: String = "",
    val ownerType: String = "",
    val contact: String = ""
)
