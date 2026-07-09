package com.lvb.studys.kotlin.api.pointofsaleapi.jwt.entity

import jakarta.persistence.*
import java.io.Serializable
import java.time.LocalDate

@Entity
@Table(name = "sale")
data class Sale(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "sales_date", nullable = false)
    var date: LocalDate,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: User,

    @OneToMany(mappedBy = "sale", fetch = FetchType.LAZY) //the referenced documents will not be loaded until they are accessed first
    var items: List<ItemSale> = ArrayList()

) : Serializable
