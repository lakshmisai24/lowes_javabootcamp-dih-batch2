package com.lowes.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lowes.bankingapp.model.FundTransfer;



public interface FundTransferRepository extends JpaRepository<FundTransfer, Integer>{
	

	}


