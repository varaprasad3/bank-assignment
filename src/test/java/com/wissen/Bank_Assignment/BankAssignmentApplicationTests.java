package com.wissen.Bank_Assignment;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.wissen.Bank_Assignment.entities.Account;
import com.wissen.Bank_Assignment.entities.Bank;
import com.wissen.Bank_Assignment.repository.AccountRepository;
import com.wissen.Bank_Assignment.repository.BankRepository;
import com.wissen.Bank_Assignment.service.AccountService;
import com.wissen.Bank_Assignment.service.BankService;


@SpringBootTest
@ExtendWith(SpringExtension.class)
class BankAssignmentApplicationTests {

	@Autowired
	AccountService accountService ;
	
	@Autowired
	BankService bankService ;
	
	@MockBean
	AccountRepository accountRepository ;
	
	@MockBean
	BankRepository bankRepository ;
	
	@Test
	public void saveAccountTest() {
		Account account = new Account(1, 123456l, "INR", 1, "MTH", 560090, 10000d) ;
		
		Bank bank = new Bank(1, "canara", null) ;
		
		List<Account> accounts = bank.getAccounts() ;
		if(accounts!=null) {
			accounts.add(account) ;
			
			bank.setAccounts(accounts);
		}
		
		else {
			List<Account> newAccounts = new ArrayList<Account>() ;
			newAccounts.add(account);
			
			bank.setAccounts(newAccounts);
		}
		
		
		
		when(accountRepository.save(account)).thenReturn(account) ;
		
	}
	
	

}
