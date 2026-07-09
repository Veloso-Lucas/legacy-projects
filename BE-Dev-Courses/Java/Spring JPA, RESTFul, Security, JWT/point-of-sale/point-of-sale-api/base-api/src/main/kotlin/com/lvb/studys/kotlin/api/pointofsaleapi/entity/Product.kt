package com.lvb.studys.kotlin.api.pointofsaleapi.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.io.Serializable
import java.math.BigDecimal

@Entity
@Table(name = "product")
data class Product(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(length = 100, nullable = false)
    var description: String,

    @Column(length = 20, precision = 20, scale = 2, nullable = false)
    var price: BigDecimal,

    @Column(nullable = true)
    var quantity: Int? = null,
) : Serializable
