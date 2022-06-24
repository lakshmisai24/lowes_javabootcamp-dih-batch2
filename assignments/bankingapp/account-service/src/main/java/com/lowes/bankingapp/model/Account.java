package com.lowes.bankingapp.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Account {
	@Id
	@GeneratedValue
	int id;
	
	@NotBlank(message = "Name cannot be empty")
	String name;
	
	@NotBlank(message=" Account Type cannot be Blank")
	String type;
	
	
	@NotBlank(message=" Status cannot be Blank")
	String status;
	
	
	@NotNull(message=" Balance cannot be empty")
    @Min(value=10000, message="Minimum amount for Balance is 10000")
	double balance;
	
	@UpdateTimestamp
	LocalDate openDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public LocalDate getOpenDate() {
		return openDate;
	}
	public void setOpenDate(LocalDate openDate) {
		this.openDate = openDate;
	}

}
