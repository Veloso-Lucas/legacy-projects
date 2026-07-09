package com.lvb.studys.kotlin.api.carrental.dto

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

    private val model: String = "",
    private val brand: String = "",
    private val price: Double = 0.0,
    private val description: String = "",
    private val engineVersion: String = "",
    private val city: String = "",
    private val createdDate: String = "",
    private val ownerId: Long = 0,
    private val ownerName: String = "",
    private val ownerType: String = "",
    private val contact: String = ""

)
