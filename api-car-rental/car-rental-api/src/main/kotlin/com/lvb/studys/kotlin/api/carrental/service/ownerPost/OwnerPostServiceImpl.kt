package com.lvb.studys.kotlin.api.carrental.service.ownerPost

import com.lvb.studys.kotlin.api.carrental.client.CarPostStoreClient
import com.lvb.studys.kotlin.api.carrental.dto.OwnerPostDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OwnerPostServiceImpl @Autowired constructor(
    private val carPostStoreClient: CarPostStoreClient
) : IOwnerPostService {

    override fun createOwnerCar(ownerPostDTO: OwnerPostDTO): OwnerPostDTO? = carPostStoreClient.ownerPostsClient(ownerPostDTO)

}