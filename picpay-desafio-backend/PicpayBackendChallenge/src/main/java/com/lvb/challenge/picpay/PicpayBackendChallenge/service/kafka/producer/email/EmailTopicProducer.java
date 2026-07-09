package com.lvb.challenge.picpay.PicpayBackendChallenge.service.kafka.producer.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class EmailTopicProducer {

    @Value("${picpay.email.topic.name}")
    private String emailTopicName;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(final String message) {
        //TODO add log
        kafkaTemplate.send(emailTopicName, message);
    }

}
