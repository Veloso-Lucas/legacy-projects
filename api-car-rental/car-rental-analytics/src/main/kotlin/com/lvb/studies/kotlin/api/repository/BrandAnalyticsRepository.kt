package com.lvb.studies.kotlin.api.repository

import com.lvb.studies.kotlin.api.entity.BrandAnalyticsEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface BrandAnalyticsRepository : JpaRepository<BrandAnalyticsEntity, Long> {

    fun findByBrand(brand: String) : Optional<BrandAnalyticsEntity>
}