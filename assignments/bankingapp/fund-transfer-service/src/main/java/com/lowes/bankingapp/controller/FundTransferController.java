package com.lowes.bankingapp.controller;

import java.net.URI;
import java.net.URISyntaxException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lowes.bankingapp.model.FundTransfer;
import com.lowes.bankingapp.model.ResponseMessage;
import com.lowes.bankingapp.service.FundTransferService;

@RestController
public class FundTransferController {
	
	@Autowired
	FundTransferService fundtransferservice;
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ResponseMessage> create(@Valid @RequestBody FundTransfer fundtransfer) throws URISyntaxException {	    	
		FundTransfer fundscreated = fundtransferservice.create(fundtransfer);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(fundscreated).toUri();
        ResponseMessage response = new ResponseMessage("Success", "Transaction created successfully");
    
        return ResponseEntity.created(location).body(response);
    }
	
}
