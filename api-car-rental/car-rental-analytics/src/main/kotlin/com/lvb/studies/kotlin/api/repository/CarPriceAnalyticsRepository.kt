package com.lvb.studies.kotlin.api.repository

import com.lvb.studies.kotlin.api.entity.CarModelPriceEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CarPriceAnalyticsRepository : JpaRepository<CarModelPriceEntity, Long> {
}