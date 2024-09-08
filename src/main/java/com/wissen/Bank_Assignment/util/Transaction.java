package com.wissen.Bank_Assignment.util;

public class Transaction {
    private Long debitAccountNumber ;
    private Long creditAccountNumber ;
    private double amount ;
	public Long getDebitAccountNumber() {
		return debitAccountNumber;
	}
	public void setDebitAccountNumber(Long debitAccountNumber) {
		this.debitAccountNumber = debitAccountNumber;
	}
	public Long getCreditAccountNumber() {
		return creditAccountNumber;
	}
	public void setCreditAccountNumber(Long creditAccountNumber) {
		this.creditAccountNumber = creditAccountNumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
    
    
    
    
}
