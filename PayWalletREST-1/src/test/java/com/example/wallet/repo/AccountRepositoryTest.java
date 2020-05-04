package com.example.wallet.repo;



import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.wallet.bean.Account;
import com.example.wallet.repo.AccountRepository1;

import org.json.JSONException;
import org.junit.Assert;


@DataJpaTest
public class AccountRepositoryTest {

	
	@Autowired
	private AccountRepository1 accountRepository;
	
	
	@BeforeAll
	static void setUpBeforeClass() {
		System.out.println("All test cases for Repository layer starting...");
	}
	
	@BeforeEach
	void setup() {
		System.out.println("Test Case Started");
	}

	@AfterEach
	void tearDown() {
		System.out.println("Test Case Over");	
	}
	
	@AfterAll
	static void setUpAfterClass() {
		System.out.println("All test cases ended.");
	}
	 @Test
	 @DisplayName("Account Test All Valid Entries")
		public void accountAllValidTest() throws ParseException{
			Account acc= new Account();
			acc.setAccountno(415263987);
			acc.setBalance(40);
			acc.setOpeningdate(LocalDate.now());
			acc.setName("Aditya");
			Date dob= new Date();
			dob= new SimpleDateFormat("dd-mm-yyy").parse("21-03-1993");
			acc.setDob(dob);
			String phno="9988776655";
			acc.setPhoneno(Long.parseLong(phno));
			acc.setAddress("Versova");
			acc.setEmail("aadi25@gmial.com");
			acc.setUsername("aadi");
			acc.setPassword("maggie123");
			assertNotNull(accountRepository.save(acc));
			
			
		}
	 
	 	@Test
		@DisplayName("Account Invalid Test ")
		public void accountAllInvalidTest() throws ParseException, JSONException{
			Account acc= new Account();
			acc.setAccountno(41526398);
			acc.setBalance(0);
			acc.setOpeningdate(LocalDate.now());
			acc.setName("Aditya");
			Date dob= new Date();
			dob= new SimpleDateFormat("dd-mm-yyy").parse("21-03-1993");
			acc.setDob(dob);
			String phno="9988776655";
			acc.setPhoneno(Long.parseLong(phno));
			acc.setAddress("");
			acc.setEmail("aadi25@gmial.com");
			acc.setUsername("aadi");
			acc.setPassword("");
			
			
	 }
		
}
