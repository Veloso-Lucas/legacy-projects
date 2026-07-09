package com.lvs.project.mscards.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue cardIssuanceQueue() {
        return new Queue("card-issuance", true);
    }

    @Bean
    public DirectExchange cardIssuanceExchange() {
        return new DirectExchange("card-issuance-exchange");
    }

    @Bean
    public Binding cardIssuanceBinding() {
        return BindingBuilder.bind(cardIssuanceQueue())
                .to(cardIssuanceExchange())
                .with("card-issuance-routing-key");
    }
}
