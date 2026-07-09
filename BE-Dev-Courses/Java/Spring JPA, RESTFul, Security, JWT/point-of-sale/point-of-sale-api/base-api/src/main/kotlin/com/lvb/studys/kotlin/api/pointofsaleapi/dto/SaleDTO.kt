package com.lvb.studys.kotlin.api.pointofsaleapi.dto

data class SaleDTO(
    var userId: Long? = null,
    var items: List<ProductSaleDTO> = ArrayList()
)
