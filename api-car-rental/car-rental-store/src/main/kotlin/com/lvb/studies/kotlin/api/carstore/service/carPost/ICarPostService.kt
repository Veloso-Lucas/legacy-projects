package com.lvb.studies.kotlin.api.carstore.service.carPost

import com.lvb.studies.kotlin.api.carstore.dto.CarPostDTO
import org.springframework.stereotype.Service

@Service
interface ICarPostService {

    fun newPostDetails(carPostDTO: CarPostDTO)

    fun getCarSales(): List<CarPostDTO>

    fun changeCarSale(carPostDTO: CarPostDTO, postId: Long)

    fun removeCarSale(postId: Long)
}