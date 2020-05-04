package com.example.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.bean.Account;

public interface AccountService {

	public Account add(Account t);
	public List<Account> getAll();
	
	public void update(Account t);
    public void deleteAccount(Integer ID);
//    public List<Account> saveAccount(Account t);
//	public List<Account> saveAll();
	/*
	 * public List<T> deposit(L accNo, K amount); public List<T> withdraw(L accNo, K
	 * amount);
	 */
	public Optional<Account> getByIdentity(Integer custID);
//	public void deposit(Integer accNo,float amount);
//	public void withdraw(Integer accNo,float amount);
//	public Map<String, Double> showBalance(Long accNo);
//	
}
