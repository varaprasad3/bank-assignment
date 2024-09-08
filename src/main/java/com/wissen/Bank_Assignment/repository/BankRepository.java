package com.wissen.Bank_Assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wissen.Bank_Assignment.entities.Bank;

public interface BankRepository extends JpaRepository<Bank, Integer> {

}
