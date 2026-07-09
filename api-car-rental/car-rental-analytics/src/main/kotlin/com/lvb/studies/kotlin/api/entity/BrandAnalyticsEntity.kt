package com.lvb.studies.kotlin.api.entity

import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType

@Entity
@Table(name = "brand_analytics")
data class BrandAnalyticsEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id : Long? = null,

    var brand: String = "",

    var posts: Long? = null

)