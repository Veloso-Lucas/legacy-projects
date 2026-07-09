package com.lvb.studys.kotlin.api.pointofsaleapi.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.io.Serializable

@Entity
@Table(name = "user")
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(length = 100, nullable = false)
    var name: String,

    var isEnabled: Boolean? = false,

    @JsonIgnore // Prevents recursion errors in HTTPS GET operations
    @OneToMany(mappedBy = "user") //the referenced documents will not be loaded until they are accessed first
    var sales: List<Sale> = ArrayList()
) : Serializable
