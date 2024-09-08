package com.wissen.Bank_Assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wissen.Bank_Assignment.entities.Bank;
import com.wissen.Bank_Assignment.service.BankService;

@RestController
public class BankController {
	
	@Autowired
	BankService bankService ;
	
	@PostMapping("/savebank")
    public ResponseEntity<Bank> saveBank(@RequestBody Bank bank) {
    	  return bankService.saveBank(bank) ;
    }
}
