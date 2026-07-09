package com.lvb.studies.kotlin.api.service

import com.lvb.studies.kotlin.api.dto.CarPostDTO
import org.springframework.stereotype.Service

@Service
interface IPostAnalyticsService {

    fun saveDataAnalytics(carPostDTO: CarPostDTO)
}