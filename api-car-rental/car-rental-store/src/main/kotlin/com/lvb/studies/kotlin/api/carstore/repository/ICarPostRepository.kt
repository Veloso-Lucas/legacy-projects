package com.lvb.studies.kotlin.api.carstore.repository

import com.lvb.studies.kotlin.api.carstore.entity.CarPostEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ICarPostRepository : JpaRepository<CarPostEntity, Long> {
}