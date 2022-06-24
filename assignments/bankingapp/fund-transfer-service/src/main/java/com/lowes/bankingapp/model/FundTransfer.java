package com.lowes.bankingapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class FundTransfer {

	@Id
	@GeneratedValue
	int id;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@NotNull(message=" Source Account Id  cannot be empty")
	int sourceAccountId ;
	
	@NotNull(message=" Target Account Id  cannot be empty")
	int targetAccoundId ;
	
	@NotNull(message=" Transaction amount cannot be empty")
    @Min(value=10000, message="Minimum amount for Transaction is 500")
	int amount;
	
	@NotBlank(message = "Description  cannot be blank")
	String description;
	
	
	public int getSourceAccountId() {
		return sourceAccountId;
	}
	public void setSourceAccountId(int sourceAccountId) {
		this.sourceAccountId = sourceAccountId;
	}
	public int getTargetAccoundId() {
		return targetAccoundId;
	}
	public void setTargetAccoundId(int targetAccoundId) {
		this.targetAccoundId = targetAccoundId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
