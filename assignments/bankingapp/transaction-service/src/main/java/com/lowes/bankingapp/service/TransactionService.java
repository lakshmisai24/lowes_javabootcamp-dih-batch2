package com.lowes.bankingapp.service;

import java.util.List;

import com.lowes.bankingapp.model.Transaction;



public interface TransactionService {
	
	public Transaction create(Transaction transaction);
	public List<Transaction> list();
	public Transaction get(int id);
	public Transaction update(int id, Transaction transaction);
	public void delete(int id);

}
