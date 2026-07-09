package com.lvb.studys.kotlin.api.pointofsaleapi.repository

import com.lvb.studys.kotlin.api.pointofsaleapi.entity.ItemSale
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemSaleRepository: JpaRepository<ItemSale, Long>