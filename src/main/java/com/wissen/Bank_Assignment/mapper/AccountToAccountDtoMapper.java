package com.wissen.Bank_Assignment.mapper;

import com.wissen.Bank_Assignment.dto.AccountDto;

import com.wissen.Bank_Assignment.entities.Account;
import com.wissen.Bank_Assignment.entities.Bank;

public class AccountToAccountDtoMapper {
    public AccountDto AccountToAccountDto(Account account, Bank bank) {
    	
    	return new AccountDto(account.getAccountNumber(), account.getCurrency(), account.getBranch(),new BankToBankDtoMapper().bankToBankDto(bank), account.getBalance()) ;
    }
}
