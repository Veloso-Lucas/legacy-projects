package com.lvb.studies.kotlin.api.service

import com.lvb.studies.kotlin.api.dto.CarPostDTO
import com.lvb.studies.kotlin.api.entity.BrandAnalyticsEntity
import com.lvb.studies.kotlin.api.entity.CarModelAnalyticsEntity
import com.lvb.studies.kotlin.api.entity.CarModelPriceEntity
import com.lvb.studies.kotlin.api.repository.BrandAnalyticsRepository
import com.lvb.studies.kotlin.api.repository.CarModelAnalyticsRepository
import com.lvb.studies.kotlin.api.repository.CarPriceAnalyticsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PostAnalyticsServiceImpl @Autowired constructor(
        private val brandAnalyticsRepository: BrandAnalyticsRepository,
        private val carModelAnalyticsRepository: CarModelAnalyticsRepository,
        private val carPriceAnalyticsRepository: CarPriceAnalyticsRepository
): IPostAnalyticsService {

    override fun saveDataAnalytics(carPostDTO: CarPostDTO) {
        saveBrandAnalytics(carPostDTO.brand)
        saveCarModelAnalytics(carPostDTO.model)
        saveCarModelPriceAnalytics(carPostDTO.model, carPostDTO.price)
    }


    private fun saveBrandAnalytics(brand: String) {
        val brandAnalyticsEntity = BrandAnalyticsEntity()

        brandAnalyticsRepository.findByBrand(brand).ifPresentOrElse({item ->
            item.posts = item.posts?.plus(1)
            brandAnalyticsRepository.save(item)
        }, {
            brandAnalyticsEntity.brand = brand
            brandAnalyticsEntity.posts = 1L
            brandAnalyticsRepository.save(brandAnalyticsEntity)
        })
    }

    private fun saveCarModelAnalytics(model: String) {
        val carModelPriceEntity = CarModelAnalyticsEntity()

        carModelAnalyticsRepository.findByModel(model).ifPresentOrElse({item->
            item.posts = item.posts?.plus(1)
            carModelAnalyticsRepository.save(item)
        }, {
            carModelPriceEntity.model = model
            carModelPriceEntity.posts = 1L
            carModelAnalyticsRepository.save(carModelPriceEntity)
        })
    }

    private fun saveCarModelPriceAnalytics(model: String, price: Double) {
        val carModelPriceEntity = CarModelPriceEntity()
        carModelPriceEntity.model = model
        carModelPriceEntity.price = price
        carPriceAnalyticsRepository.save(carModelPriceEntity)

    }
}