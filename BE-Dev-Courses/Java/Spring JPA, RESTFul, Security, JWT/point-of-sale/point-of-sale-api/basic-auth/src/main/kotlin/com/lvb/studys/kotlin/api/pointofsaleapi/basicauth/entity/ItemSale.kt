package com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.io.Serializable

@Entity
@Table(name = "item_sale")
data class ItemSale(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @JsonIgnore // Prevents recursion errors in HTTPS GET operations
    @ManyToOne
    @JoinColumn(name = "sale_id", nullable = false)
    var sale: Sale? = null,

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    val product: Product,

    @Column(nullable = false)
    val quantity: Int

) : Serializable
