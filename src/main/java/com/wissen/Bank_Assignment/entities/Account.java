package com.wissen.Bank_Assignment.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Account {

	@Id
	private Integer id;
	private Long accountNumber;
	private String currency;
	
	private int bankId;
	private String branch;
	private Integer pincode;
	
	private double balance ;
	
	

	public Account(Integer id, Long accountNumber, String currency, int bankId, String branch, Integer pincode,
			double balance) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.currency = currency;
		this.bankId = bankId;
		this.branch = branch;
		this.pincode = pincode;
		this.balance = balance;
	}

	
	public Account() {}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

}
