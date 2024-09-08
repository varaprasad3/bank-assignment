package com.wissen.Bank_Assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wissen.Bank_Assignment.dto.AccountDto;
import com.wissen.Bank_Assignment.entities.Account;
import com.wissen.Bank_Assignment.service.AccountService;
import com.wissen.Bank_Assignment.util.PaymentInstruction;
import com.wissen.Bank_Assignment.util.Transaction;

@RestController
public class AccountController {
    @Autowired
    AccountService accountService ;
    
    
    
    @PostMapping("/saveaccount")
    public ResponseEntity<Account> saveBank(@RequestBody Account account) {
    	    return accountService.saveAccount(account) ;
    }
    
    @GetMapping("/fetchAccount")
    public ResponseEntity<AccountDto> findAccountById(@RequestParam Long accountnumber ) throws Exception {
    	return accountService.findAccountByAccountNumber(accountnumber) ;
    	
    }
    
    @PutMapping("/makeaccounttransaction")
    public ResponseEntity<Transaction> findAccountNumber(@RequestBody Transaction transaction) throws Exception {
         return accountService.findAccountNumber(transaction) ;
    }
}
