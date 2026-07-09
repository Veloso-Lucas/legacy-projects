package com.lvb.studys.kotlin.api.carrental.dto

import com.fasterxml.jackson.annotation.JsonInclude
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import java.io.Serializable

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude
data class OwnerPostDTO(

    private val name: String,
    private val type: String,
    private val contactNumber: String
) : Serializable
