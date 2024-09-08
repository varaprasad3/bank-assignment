package com.wissen.Bank_Assignment;

import java.util.List;


import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.web.reactive.function.client.WebClient;

import com.wissen.Bank_Assignment.util.PaymentInstruction;

@SpringBootApplication
public class BankAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAssignmentApplication.class, args);
	}

	@Bean
	public WebClient webClient() {
		return WebClient.builder().build();
	}

	@Bean
	public KafkaTemplate<String, List<PaymentInstruction>> kafkaTemplate(
			ProducerFactory<String, List<PaymentInstruction>> producerFactory) {
		return new KafkaTemplate<>(producerFactory);
	}

	
}
