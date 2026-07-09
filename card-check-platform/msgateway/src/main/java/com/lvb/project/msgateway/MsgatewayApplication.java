package com.lvb.project.msgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class MsgatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsgatewayApplication.class, args);
    }

    @Bean
    public RouteLocator route(RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route(r -> r
                        .path("/customers/**")                  // if the URL start with /customers/
                        .uri("lb://msclients"))                          // Redirect using the name of service (using Eureka)
                .route(r -> r
                        .path("/cards/**")                     // if the URL start with /cards/
                        .uri("lb://mscards"))                           // Redirect using the name of service (using Eureka)
                .route(r -> r
                        .path("/credit-evaluations/**")        // if the URL start with /credit-evaluations/
                        .uri("lb://mscreditassessor"))                  // Redirect using the name of service (using Eureka)
                .build();
    }


}
