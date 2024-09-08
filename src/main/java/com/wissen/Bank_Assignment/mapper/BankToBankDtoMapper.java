package com.wissen.Bank_Assignment.mapper;

import com.wissen.Bank_Assignment.dto.BankDto;
import com.wissen.Bank_Assignment.entities.Bank;

public class BankToBankDtoMapper {
    public BankDto bankToBankDto(Bank bank) {
    	return new BankDto(bank.getId(), bank.getName()) ;
    }
}
