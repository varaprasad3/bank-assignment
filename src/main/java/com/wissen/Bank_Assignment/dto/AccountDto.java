package com.wissen.Bank_Assignment.dto;

public class AccountDto {
	private Long accountNumber;
	private String currency;
	private String branch;
	private BankDto bank;
	private double balance ;

	public AccountDto(Long accountNumber, String currency, String branch, BankDto bank, double balance) {

		this.accountNumber = accountNumber;
		this.currency = currency;
		this.branch = branch;
		this.bank = bank;
		this.balance = balance;
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

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	
	public BankDto getBank() {
		return bank;
	}

	public void setBank(BankDto bank) {
		this.bank = bank;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	
}
