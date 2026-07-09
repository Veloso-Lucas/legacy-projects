package com.lvb.studies.kotlin.api.carstore.service.carPost

import com.lvb.studies.kotlin.api.carstore.repository.ICarPostRepository
import com.lvb.studies.kotlin.api.carstore.repository.IOwnerPostRepository
import com.lvb.studies.kotlin.api.carstore.dto.CarPostDTO
import com.lvb.studies.kotlin.api.carstore.entity.CarPostEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CarPostServiceImpl @Autowired constructor(
    private val carPostRepository: ICarPostRepository,
    private val ownerPostRepository: IOwnerPostRepository
) : ICarPostService {

    override fun newPostDetails(carPostDTO: CarPostDTO) {
        val carPostEntity = generateCarPostFromDTO(carPostDTO)
        carPostRepository.save(carPostEntity)
    }

    override fun getCarSales(): List<CarPostDTO> {
        val listCarsSales = ArrayList<CarPostDTO>()

        carPostRepository.findAll().forEach {
            listCarsSales.add(generateCarPostDTO(it))
        }
        return listCarsSales
    }

    override fun changeCarSale(carPostDTO: CarPostDTO, postId: Long) {
        carPostRepository.findById(postId).ifPresent {
            it.description = carPostDTO.description
            it.contact = carPostDTO.contact
            it.price = carPostDTO.price
            it.brand = carPostDTO.brand
            it.engineVersion = carPostDTO.engineVersion
            it.model = carPostDTO.model
            it.description = carPostDTO.description

            carPostRepository.save(it)
        }
    }

    override fun removeCarSale(postId: Long) {
        carPostRepository.deleteById(postId)
    }

    private fun generateCarPostDTO(carPostEntity: CarPostEntity) : CarPostDTO {
        return CarPostDTO(
            brand = carPostEntity.brand,
            city = carPostEntity.city,
            model = carPostEntity.model,
            description = carPostEntity.description,
            engineVersion = carPostEntity.engineVersion,
            createdDate = carPostEntity.createdDate,
            ownerName = carPostEntity.ownerPost.name,
            price = carPostEntity.price,
        )
    }

    private fun generateCarPostFromDTO(carPostDTO: CarPostDTO): CarPostEntity {
        val carPostEntity = CarPostEntity()

        ownerPostRepository.findById(carPostDTO.ownerId).ifPresent {
            carPostEntity.ownerPost = it
            carPostEntity.contact = it.contactNumber
        }
        carPostEntity.model = carPostDTO.model
        carPostEntity.price = carPostDTO.price
        carPostEntity.brand = carPostDTO.brand
        carPostEntity.city = carPostDTO.city
        carPostEntity.description = carPostDTO.description
        carPostEntity.engineVersion = carPostDTO.engineVersion
        carPostEntity.createdDate = carPostDTO.createdDate

        return carPostEntity
    }
}