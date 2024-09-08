package com.wissen.Bank_Assignment.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wissen.Bank_Assignment.entities.Bank;
import com.wissen.Bank_Assignment.repository.BankRepository;

@Service
public class BankService {
	
	
	private  BankRepository bankRepository ;
	
	
	
    public BankService(BankRepository bankRepository) {
		
		this.bankRepository = bankRepository;
	}



	public ResponseEntity<Bank> saveBank(Bank bank) {
      Bank savedBank = 	 bankRepository.save(bank) ;
      
      return new ResponseEntity<Bank>(savedBank, HttpStatus.CREATED) ;
    }
}
