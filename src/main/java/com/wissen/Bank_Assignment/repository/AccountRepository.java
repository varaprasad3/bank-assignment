package com.wissen.Bank_Assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wissen.Bank_Assignment.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{
             Account findByAccountNumber(Long accountNumber) ;
}
