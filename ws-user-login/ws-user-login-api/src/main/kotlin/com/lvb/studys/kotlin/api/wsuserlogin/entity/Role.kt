package com.lvb.studys.kotlin.api.wsuserlogin.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.io.Serializable

@Document
data class Role(

    @Id
    var id: String? = null,

    var name: String = ""

): Serializable
