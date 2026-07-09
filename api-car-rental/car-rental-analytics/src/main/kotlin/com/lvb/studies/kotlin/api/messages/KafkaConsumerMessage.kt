package com.lvb.studies.kotlin.api.messages

import com.lvb.studies.kotlin.api.dto.CarPostDTO
import com.lvb.studies.kotlin.api.service.IPostAnalyticsService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class KafkaConsumerMessage @Autowired constructor(
    private val iPostAnalyticsService: IPostAnalyticsService
) {

    private val log = LoggerFactory.getLogger(KafkaConsumerMessage::class.java)

    @KafkaListener(topics = ["car-post-topic"], groupId = "analytics-posts-group")
    fun listening(@Payload carPostDTO: CarPostDTO) {
        log.info("Received Car Post information: {$carPostDTO}")

        iPostAnalyticsService.saveDataAnalytics(carPostDTO)
    }


}