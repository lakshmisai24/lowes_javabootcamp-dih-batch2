package com.lowes.bankingapp.model;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Transaction {
	@Id
	@GeneratedValue
	int id;
	
	@NotBlank(message = "Transaction Type cannot be blank")
	String type;
	
	@NotBlank(message = "Description  cannot be blank")
	String description;
	
	@NotNull(message=" Transaction amount cannot be empty")
    @Min(value=10000, message="Minimum amount for Transaction is 500")
	double amount;
	
	@NotNull(message=" AccountId  cannot be empty")
	int accountId;
	
	@UpdateTimestamp
    LocalTime transactionTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public LocalTime getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(LocalTime transactionTime) {
		this.transactionTime = transactionTime;
	}
}
