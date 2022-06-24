package com.lowes.bankingapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.lowes.bankingapp.model.Account;
import com.lowes.bankingapp.repository.AccountRepository;
import com.lowes.bankingapp.service.AccountService;



@SpringBootTest
public class AccountServiceJunitTests {

	@Autowired
	AccountService accountService;

	@MockBean
	AccountRepository accountRepo;
	

    //@Autowired
    //LocalDate openDate;

	@BeforeAll
	public static void init() {
		// Logic to initialize test data goes here
		System.out.println("Test data initialization at class level..");
	}

	@AfterAll
	public static void tearDown() {
		// Logic to clean up test data goes here
		System.out.println("Test data clean up at class level..");
	}
	
	private static List<Account> accounts = new ArrayList<>();

	@BeforeEach
	public void setup() {
		// Initialize Test data
Account account1 = new Account();
    	
    	account1.setId(1);
    	account1.setName("Lakshmi");
    	account1.setBalance(200000);
    	//account1.setOpenDate(openDate);
    	account1.setType("Active");
    	account1.setStatus("Current");
    	
    	accounts.add(account1);
    	
       Account account2 = new Account();
    	
    	account2.setId(2);
    	account2.setName("Sai");
    	account2.setBalance(250000);
    	//account2.setOpenDate(openDate);
    	account2.setType("Savings");
    	account2.setStatus("Active");
    	
    	accounts.add(account2);
	}

	@AfterEach
	public void cleanup() {
		accounts.clear();
	}

	/*@Test
	public void shouldCreateProductWhenPassingMandatoryDetails() {
		Account account = new Account();
		account.setBalance(2000);
		account.setStatus("closed");	
		accountService.update(2, account);	
		assertNotNull(accountService.get(2));
		assertEquals("Sai", accountService.get(2).getName());
}*/

	@Test
	public void shouldShowErrorWhenNotPassingMandatoryDetails() {
		Account account = new Account();
		try {
			accountService.createAccount(account);
		} catch (Exception e) {
			assertEquals("Account Id mandatory", e.getMessage());
		}
	}

	/*@Test
	public void shouldUpdateProductForGivenProductId() {
		Account account = new Account();
		account.setName("Kumar");
		account.setStatus("Active");
		account.setType("Savings");

		accountService.update(2, account);

		assertNotNull(accountService.get(2));
		assertEquals("Kumar", accountService.get(2).getName());
	}*/

	/*@Test
	public void shouldDeleteProductWhenPassingValidProductId() {
		accountService.delete(2);
		assertNull(accountService.get(2));
		//assertEquals(2, accountService.list().size());
	}*/

	@Test
	public void shouldReturnProductForGivenProductId() {
		Mockito.when(accountRepo.findById(2)).thenReturn(Optional.of(accounts.get(1)));
		
		
		assertNotNull(accountService.get(2));
		assertEquals(2, accountService.get(2).getId());
	}

	@Test
	public void shouldReturnAllProductsWhenDontSpecifyProductId() {
		Mockito.when(accountRepo.findAll()).thenReturn(accounts);
		
		assertEquals(2, accountService.list().size());
	}

}
