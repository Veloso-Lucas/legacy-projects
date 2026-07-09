package com.lvb.studys.kotlin.api.carrental.service.ownerPost

import com.lvb.studys.kotlin.api.carrental.dto.OwnerPostDTO
import org.springframework.stereotype.Service

@Service
interface IOwnerPostService {
    fun createOwnerCar(ownerPostDTO: OwnerPostDTO): OwnerPostDTO?
}