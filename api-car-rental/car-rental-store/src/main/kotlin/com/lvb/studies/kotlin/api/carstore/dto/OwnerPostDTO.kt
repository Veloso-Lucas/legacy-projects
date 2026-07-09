package com.lvb.studies.kotlin.api.carstore.dto

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

    val name: String,
    val type: String,
    val contactNumber: String

) : Serializable
