package com.lvb.studys.kotlin.api.carrental.client

import com.lvb.studys.kotlin.api.carrental.dto.CarPostDTO
import com.lvb.studys.kotlin.api.carrental.dto.OwnerPostDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.*
import org.springframework.stereotype.Component
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.client.RestTemplate
import java.util.*


@Component
class CarPostStoreClient @Autowired constructor(
    private val restTemplate: RestTemplate
) {

    private val USER_STORE_SERVICE_URI = "http://localhost:8086/user"
    private val POST_STORE_SERVICE_URI = "http://localhost:8082/sales"


    fun carForSaleClient(): List<CarPostDTO> {
        val responseEntity = restTemplate.getForEntity("$POST_STORE_SERVICE_URI/cars", Array<CarPostDTO>::class.java)
        return responseEntity.body?.toList() ?: listOf(CarPostDTO())
    }

    fun ownerPostsClient(newUser: OwnerPostDTO): OwnerPostDTO? {

        return restTemplate.postForEntity(USER_STORE_SERVICE_URI, newUser, OwnerPostDTO::class.java).body
        /*
            try {
            return restTemplate.postForEntity(USER_STORE_SERVICE_URI, newUser, OwnerPostDTO::class.java).body
        } catch (e: Exception) {
            if(e.message != null) {

            }
        }
        return newUser*/
    }

    fun changeCarForSaleClient(carPostDTO: CarPostDTO, id: String) = restTemplate.put("$POST_STORE_SERVICE_URI/car/$id", carPostDTO, CarPostDTO::class.java)

    fun deleteCarForSaleClient(id: String) = restTemplate.delete("$POST_STORE_SERVICE_URI/car/$id")

}