package com.lvb.studys.kotlin.api.carrental.client

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.client.RestTemplate


@Configuration
@ComponentScan("com.lvb.studys.kotlin.api")
class RestTemplateConfig {

    @Bean
    fun restTemplate() : RestTemplate {
        val restTemplate = RestTemplate()
        val converter = MappingJackson2HttpMessageConverter()
        converter.objectMapper = ObjectMapper()
        restTemplate.messageConverters.add(converter)
        return restTemplate
    }

    /*fun restTemplate(builder: RestTemplateBuilder) : RestTemplate {
        return builder.setConnectTimeout(Duration.ofMillis(300000))
            .setReadTimeout(Duration.ofMillis(300000)).build()
    }*/
}