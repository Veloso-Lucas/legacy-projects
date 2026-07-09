package com.lvb.studys.kotlin.api.carrental.message

import com.lvb.studys.kotlin.api.carrental.dto.CarPostDTO
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory
import org.springframework.kafka.support.serializer.JsonSerializer
import org.springframework.stereotype.Component

@Component
@Configuration
class KafkaProducerConfiguration constructor(
    @Value("\${spring.kafka.bootstrap-servers}")
    private val bootstrapServer: String
) {

    @Bean
    fun userProducerFactory() : ProducerFactory<String, CarPostDTO> {

        val configProps = HashMap<String, Any>()

        configProps[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapServer
        configProps[JsonSerializer.ADD_TYPE_INFO_HEADERS] = false
        configProps[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java.name
        configProps[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = JsonSerializer::class.java.name

        return DefaultKafkaProducerFactory(configProps)

    }

    @Bean
    fun userKafkaTemplate(): KafkaTemplate<String, CarPostDTO> {
        return KafkaTemplate(userProducerFactory())
    }


}