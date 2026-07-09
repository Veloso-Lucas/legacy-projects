package com.lvb.studys.kotlin.api.pointofsaleapi.jwt.repository

import com.lvb.studys.kotlin.api.pointofsaleapi.jwt.entity.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository: JpaRepository<Product, Long>