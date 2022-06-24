package com.lowes.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lowes.bankingapp.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

}
