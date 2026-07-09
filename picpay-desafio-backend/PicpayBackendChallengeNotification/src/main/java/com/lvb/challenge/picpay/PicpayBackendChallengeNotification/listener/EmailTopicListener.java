package com.lvb.challenge.picpay.PicpayBackendChallengeNotification.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmailTopicListener {

    @KafkaListener(topics = "${picpay.email.topic.name}", groupId = "picpay_backend_challenge_notification")
    public void consumeEmailTopic(final ConsumerRecord<String, String> payload) {

        if (payload != null) {

        }

    }

}
