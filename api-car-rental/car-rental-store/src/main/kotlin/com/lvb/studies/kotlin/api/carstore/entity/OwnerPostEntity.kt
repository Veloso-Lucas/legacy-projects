package com.lvb.studies.kotlin.api.carstore.entity

import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Column
import lombok.Data
import lombok.NoArgsConstructor

@Entity
@Table(name = "owner_post")
@Data
@NoArgsConstructor
data class OwnerPostEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,

    var name: String = "",

    @Column(name = "owner_type")
    var type: String = "",

    @Column(name = "owner_contact")
    var contactNumber: String = ""
)
