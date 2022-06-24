package com.lowes.bankingapp.service;

import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.lowes.bankingapp.model.Account;
import com.lowes.bankingapp.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{
	Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	@Autowired
    AccountRepository accRepo;
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;	
	
	@Override
	public Account create(Account account) {	
		return accRepo.save(account);	
	}

	@Override
	public List<Account> list() {
		
		List<Account> acclIst = accRepo.findAll();
    	return acclIst;
	}

	@Override
	public Account get(int id) {
		
		return accRepo.findById(id).get();
	}

	@Override
	public Account update(int id, Account account) {
		
		return accRepo.save(account);
	}

	@Override
	public void delete(int id) {
		accRepo.deleteById(id);
		
	}
	
	 @KafkaListener(topics = "FUNDTRANSFER_CREATED", groupId="account-service")//fundtransfer created-transation
	    public void listenOrderApproval(ConsumerRecord<?, ?> cr) throws Exception {
	        System.out.println("###################Order Created: " + cr.value());

	        String msg = (String) cr.value();
	        String[] tokens = msg.split(",");
	        String 	sourceAccountId = tokens[0];	        
	        String targetAccountId=tokens[1];
	        String debitedAmount = tokens[2];
	        
	        
	        double damt = Double.valueOf(debitedAmount);
	        
	        // Logic to check Account limit        
	        Account accountSource = accRepo.findById(Integer.valueOf(sourceAccountId)).get();
	        double balanceSource = accountSource.getBalance();
	        
	        Account accountTarget=accRepo.findById(Integer.valueOf(targetAccountId)).get();
	        double balanceTarget=accountTarget.getBalance();
	        
	        if(balanceSource >= damt) {
	        	//Debit amount from source account
	        	accountSource.setBalance(balanceSource-damt);
	        	accountSource.setStatus("Pending");
	        	System.out.println("Amount Debited from account:: " + sourceAccountId);
	        	accRepo.save(accountSource);
	        	
	        	//Credit amount from target account
	        	accountTarget.setBalance(balanceTarget+damt);
	        	accRepo.save(accountTarget);
	        	System.out.println("Amount Credited from account:: " + targetAccountId);
	        	kafkaTemplate.send("TRANSACTION-COMPLETED", sourceAccountId);
	        }
	        else {
	        	accountSource.setBalance(balanceSource);
	        	accountSource.setStatus("Pending");
	        	System.out.println("TRANSACTION-FAILED :: " + sourceAccountId);
	        	kafkaTemplate.send("TRANSACTION-FAILED", sourceAccountId);
	        }        
	    }

	@Override
	public String createAccount(Account account) {
		accRepo.save(account);
		return "Account created";
	}
	
}
