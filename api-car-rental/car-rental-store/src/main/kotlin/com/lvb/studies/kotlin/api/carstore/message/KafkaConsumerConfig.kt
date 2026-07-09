package com.lvb.studies.kotlin.api.carstore.message

import com.lvb.studies.kotlin.api.carstore.dto.CarPostDTO
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer

@EnableKafka
@Configuration
class KafkaConsumerConfig constructor(
    @Value("\${spring.kafka.bootstrap-servers}")
    private val bootstrapServer: String
) {

    @Bean
    fun consumerFactory(): ConsumerFactory<String, CarPostDTO> {

        val configProps = HashMap<String, Any>()

        configProps[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapServer
        configProps[ConsumerConfig.GROUP_ID_CONFIG] = "store-posts-group"
        configProps[JsonDeserializer.TRUSTED_PACKAGES] = "*"

        configProps[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java.name
        configProps[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = JsonDeserializer::class.java.name

        return DefaultKafkaConsumerFactory(
            configProps,
            StringDeserializer(),
            JsonDeserializer(CarPostDTO::class.java, false)
        )

    }

    @Bean
    fun kafkaListenerContainerFactory() : ConcurrentKafkaListenerContainerFactory<String, CarPostDTO> {
        val factory = ConcurrentKafkaListenerContainerFactory<String, CarPostDTO>()
        factory.consumerFactory = consumerFactory()
        return factory
    }
}