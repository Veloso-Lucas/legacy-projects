package com.lvs.project.mscards.jms;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CardIssuanceSubscriber {

    @RabbitListener(queues = "card-issuance")
    public void receiveCardRequest(@Payload String message) {

    }
}
