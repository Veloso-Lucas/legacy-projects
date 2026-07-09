package com.lvb.studies.kotlin.api.carstore.entity

import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Column
import jakarta.persistence.ManyToOne
import jakarta.persistence.JoinColumn
import lombok.Data
import lombok.NoArgsConstructor

@Entity
@Table(name = "car_post")
@Data
@NoArgsConstructor
data class CarPostEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,

    @Column(name="car_model")
    var model: String = "",

    @Column(name="car_brand")
    var brand: String = "",

    @Column(name="car_price")
    var price: String = "",

    @Column(name="car_description")
    var description: String = "",

    @Column(name="car_engine")
    var engineVersion: String = "",

    @Column(name="car_city")
    var city: String = "",

    @Column(name="car_created")
    var createdDate: String = "",

    @Column(name="car_contact")
    var contact: String = "",

    @ManyToOne
    @JoinColumn(name = "owner_post_id", nullable = false, referencedColumnName = "id")
    var ownerPost: OwnerPostEntity = OwnerPostEntity()

)
