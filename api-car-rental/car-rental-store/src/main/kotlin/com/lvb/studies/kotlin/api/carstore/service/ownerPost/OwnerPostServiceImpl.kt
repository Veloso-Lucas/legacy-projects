package com.lvb.studies.kotlin.api.carstore.service.ownerPost

import com.lvb.studies.kotlin.api.carstore.entity.OwnerPostEntity
import com.lvb.studies.kotlin.api.carstore.repository.IOwnerPostRepository
import com.lvb.studies.kotlin.api.carstore.dto.OwnerPostDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OwnerPostServiceImpl @Autowired constructor(
    private val ownerRepository: IOwnerPostRepository
): IOwnerPostService {

    override fun createOwnerPost(ownerPostDTO: OwnerPostDTO) {
        val ownerPostEntity = OwnerPostEntity()

        ownerPostEntity.name = ownerPostDTO.name
        ownerPostEntity.type = ownerPostDTO.type
        ownerPostEntity.contactNumber = ownerPostDTO.contactNumber

        ownerRepository.save(ownerPostEntity)
    }
}