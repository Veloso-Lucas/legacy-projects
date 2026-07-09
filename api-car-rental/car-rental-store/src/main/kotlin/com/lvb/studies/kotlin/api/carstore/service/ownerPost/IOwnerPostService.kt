package com.lvb.studies.kotlin.api.carstore.service.ownerPost

import com.lvb.studies.kotlin.api.carstore.dto.OwnerPostDTO
import org.springframework.stereotype.Service

@Service
interface IOwnerPostService {

    fun createOwnerPost(ownerPostDTO: OwnerPostDTO)
}