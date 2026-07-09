package com.lvb.studies.kotlin.api.carstore.repository

import com.lvb.studies.kotlin.api.carstore.entity.OwnerPostEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IOwnerPostRepository : JpaRepository<OwnerPostEntity, Long> {
}