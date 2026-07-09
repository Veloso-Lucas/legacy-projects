package com.lvb.studies.kotlin.api.carstore.message

import com.lvb.studies.kotlin.api.carstore.dto.CarPostDTO
import com.lvb.studies.kotlin.api.carstore.service.carPost.ICarPostService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class KafkaConsumerMessage @Autowired constructor(
    private val iCarPostService: ICarPostService
) {

    private val log = LoggerFactory.getLogger(KafkaConsumerMessage::class.java)

    @KafkaListener(topics = ["car-post-topic"], groupId = "store-posts-group")
    fun listening(carPostDTO: CarPostDTO) {
        log.info("Received Car Post information: {$carPostDTO}")

        iCarPostService.newPostDetails(carPostDTO)
    }


}