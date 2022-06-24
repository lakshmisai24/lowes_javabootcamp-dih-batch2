package com.lowes.bankingapp.service;

import java.util.List;
import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


import com.lowes.bankingapp.model.Transaction;
import com.lowes.bankingapp.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{
	Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;	
	
	@Autowired
    TransactionRepository transRepo;
	
	
	@Override
	public Transaction create(Transaction transaction) {
		transRepo.save(transaction);
		return transaction;		
	}

	@Override
	public List<Transaction> list() {
		List<Transaction> tranList = transRepo.findAll();
    	return tranList;
	}

	@Override
	public Transaction get(int id) {
		return transRepo.findById(id).get();
	}

	@Override
	public Transaction update(int id, Transaction transaction) {
		return transRepo.save(transaction);
	}

	@Override
	public void delete(int id) {
		transRepo.deleteById(id);
		
	}
	
	
	
	@KafkaListener(topics = "FUNDTRANSFER_CREATED", groupId="transaction-service")//fundtransfer created-transation
    public void listenFundTransfer(ConsumerRecord<?, ?> cr) throws Exception {
        System.out.println("###################FundTransfer Created: " + cr.value());

        String msg = (String) cr.value();
        String[] tokens = msg.split(",");
        String 	sourceAccountId = tokens[0];
        String 	targetAccountId = tokens[1];
        String Amount = tokens[2];
        String description=tokens[3];
        String tranType="Debit";
       
        
        double amt = Double.valueOf(Amount);
        Transaction transaction=new Transaction();
        transaction.setAccountId(Integer.valueOf(sourceAccountId));
        transaction.setAmount(amt);
        transaction.setDescription(description);
        transaction.setType(tranType);  
        //Saving into transaction
        transRepo.save(transaction);
       
       
        String tranType1="Credit";
        //Saving into transaction
        Transaction transaction1=new Transaction();
        transaction1.setAccountId(Integer.valueOf(targetAccountId));
        transaction1.setAmount(amt);
        transaction1.setDescription(description);
        transaction1.setType(tranType1);  
        transRepo.save(transaction1);
        }
	
	@KafkaListener(topics = "TRANSACTION-FAILED", groupId="transaction-service")//fundtransfer created-transation
    public void listenAccountRejected(ConsumerRecord<?, ?> cr) throws Exception {
        System.out.println("###################Transaction failed: " + cr.value());
        }

    }


