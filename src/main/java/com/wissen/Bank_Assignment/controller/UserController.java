package com.wissen.Bank_Assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.wissen.Bank_Assignment.util.Transaction;

import reactor.core.publisher.Mono;

@RestController
public class UserController {

	@Autowired
	WebClient.Builder webClient;

	@PostMapping("/maketransaction")
	public Mono<String> saveTransaction(@RequestBody Transaction transaction) {
		return webClient.build().put().uri("http://localhost:8080/makeaccounttransaction")
				.body(Mono.just(transaction), Transaction.class).retrieve().bodyToMono(String.class);
	}
}
