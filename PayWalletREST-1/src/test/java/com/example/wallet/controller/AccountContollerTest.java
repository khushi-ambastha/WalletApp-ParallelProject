package com.example.wallet.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import static org.junit.Assert.assertNotNull;

import org.json.JSONException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.wallet.bean.Account;
import com.example.wallet.contoller.AccountController;

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback
public class AccountContollerTest {

	
	@Autowired
	AccountController accountController;
	
	@BeforeAll
	static void setUpBeforeClass() {
		System.out.println("All test cases for Controller layer starting...");
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
		assertNotNull(accountController.createAccount(acc));
		
		
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
		
		JSONAssert.assertEquals("{success:false}",accountController.createAccount(acc),JSONCompareMode.LENIENT);
	}
	
}
