package com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.dto

import java.math.BigDecimal

data class ProductInfoDTO(
    var id: Long,
    var description: String,
    var price: BigDecimal,
    var quantity: Int
)
