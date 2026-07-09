package com.lvb.studys.kotlin.api.carrental.message

import com.lvb.studys.kotlin.api.carrental.dto.CarPostDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class KafkaProduceMessage @Autowired constructor(
  private val kafkaTemplate: KafkaTemplate<String, CarPostDTO>
) {

    private val KAFKA_TOPIC = "car-post-topic"

    fun sendMessage(carPostDTO: CarPostDTO) {
        kafkaTemplate.send(KAFKA_TOPIC, carPostDTO)
    }

}