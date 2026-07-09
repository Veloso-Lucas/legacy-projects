package com.lvb.studys.kotlin.api.carrental.service.carPost

import com.lvb.studys.kotlin.api.carrental.dto.CarPostDTO

interface ICarPostStoreService {

    fun getCarForSales() : List<CarPostDTO>

    fun changeCarForSale(carPost: CarPostDTO, id: String)

    fun removerCarForSale(id: String)
}