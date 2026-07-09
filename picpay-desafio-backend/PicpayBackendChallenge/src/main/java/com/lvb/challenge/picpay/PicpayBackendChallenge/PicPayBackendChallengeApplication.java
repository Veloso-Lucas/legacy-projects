package com.lvb.challenge.picpay.PicpayBackendChallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class PicPayBackendChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PicPayBackendChallengeApplication.class, args);
	}

}
