package com.lvb.studies.kotlin.api.entity

import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType

@Entity
@Table(name = "car_model_analytics")
data class CarModelAnalyticsEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id : Long? = null,

    var model: String = "",

    var posts: Long? = null
)