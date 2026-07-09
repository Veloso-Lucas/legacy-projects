package com.lvb.studys.kotlin.api.carrental.service.carPost

import com.lvb.studys.kotlin.api.carrental.client.CarPostStoreClient
import com.lvb.studys.kotlin.api.carrental.dto.CarPostDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CarPostStoreServiceImpl @Autowired constructor(
    private val carStoreClient: CarPostStoreClient
) : ICarPostStoreService {

    override fun getCarForSales(): List<CarPostDTO> {
        return carStoreClient.carForSaleClient()
    }

    override fun changeCarForSale(carPost: CarPostDTO, id: String) {
        carStoreClient.changeCarForSaleClient(carPost, id)
    }

    override fun removerCarForSale(id: String) {
        carStoreClient.deleteCarForSaleClient(id)
    }
}