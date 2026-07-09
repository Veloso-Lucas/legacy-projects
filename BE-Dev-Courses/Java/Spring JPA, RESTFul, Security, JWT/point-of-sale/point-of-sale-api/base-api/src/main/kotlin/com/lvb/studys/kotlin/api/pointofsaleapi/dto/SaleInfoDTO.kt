package com.lvb.studys.kotlin.api.pointofsaleapi.dto

import java.math.BigDecimal

data class SaleInfoDTO(

    var user: String,
    var date: String,
    var total: BigDecimal,
    var products: List<ProductInfoDTO>
)
