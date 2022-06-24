package com.lowes.bankingapp.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.lowes.bankingapp.model.FundTransfer;
import com.lowes.bankingapp.repository.FundTransferRepository;

@Service
public class FundTransferImpl implements FundTransferService{

Logger logger = LoggerFactory.getLogger(FundTransferImpl.class);
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	FundTransferRepository ftrepo;
	
	@Override
	public FundTransfer create(FundTransfer fundtransfer) {
		
		ftrepo.save(fundtransfer);
		
		String msg = fundtransfer.getSourceAccountId() +","+fundtransfer.getTargetAccoundId() + ","+fundtransfer.getAmount()+","+String.valueOf(fundtransfer.getDescription());
		
		kafkaTemplate.send("FUNDTRANSFER_CREATED", msg);
		
		return fundtransfer;
	}
	@KafkaListener(topics = "TRANSACTION-FAILED", groupId="transaction-service")//fundtransfer created-transation
    public void listenAccountRejected(ConsumerRecord<?, ?> cr) throws Exception {
        System.out.println("###################Transaction failed: " + cr.value());
        }
}
