package com.lvb.studys.kotlin.api.pointofsaleapi.repository

import com.lvb.studys.kotlin.api.pointofsaleapi.entity.Sale
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SaleRepository: JpaRepository<Sale, Long>