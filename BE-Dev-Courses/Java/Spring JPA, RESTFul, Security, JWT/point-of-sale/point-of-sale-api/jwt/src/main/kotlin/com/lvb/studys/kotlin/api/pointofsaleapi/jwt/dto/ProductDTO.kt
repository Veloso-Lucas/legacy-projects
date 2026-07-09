package com.lvb.studys.kotlin.api.pointofsaleapi.jwt.dto

import java.math.BigDecimal

data class ProductDTO (
    var id : Long,
    var description: String,
    var price: BigDecimal,
    var quantity: Int
)
