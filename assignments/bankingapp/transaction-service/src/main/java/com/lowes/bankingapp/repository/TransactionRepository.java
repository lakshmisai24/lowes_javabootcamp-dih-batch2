package com.lowes.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lowes.bankingapp.model.Transaction;



public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

}
