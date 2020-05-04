package com.example.wallet.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.wallet.bean.Account;
import com.example.wallet.exceptions.AccountException;

public interface AccountService {

	public Account add(Account t);
	public List<Account> getAll();
	
	public void update(Account t) throws AccountException;
    public void deleteAccount(Long ID);
	public Account getByIdentity(Long accountno);
	public void deposit(Long accNo,float amount);
	public void withdraw(Long accNo,float amount);

	
}
