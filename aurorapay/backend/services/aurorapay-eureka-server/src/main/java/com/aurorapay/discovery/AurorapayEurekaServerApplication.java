package com.aurorapay.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class AurorapayEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AurorapayEurekaServerApplication.class, args);
	}

}
