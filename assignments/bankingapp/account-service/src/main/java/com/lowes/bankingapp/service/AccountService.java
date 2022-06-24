package com.lowes.bankingapp.service;

import java.util.List;

import com.lowes.bankingapp.model.Account;

public interface AccountService {
	public Account create(Account account);
	public List<Account> list();
	public Account get(int id);
	public Account update(int id, Account account);
	public void delete(int id);
	public String createAccount(Account account);
}
