package com.example.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.Account;
import com.example.bean.Transaction;
import com.example.repo.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accRepo;
	
	private Transaction tr;

	@Override
	public Account add(Account t) {
		// TODO Auto-generated method stub
		return accRepo.save(t);
		
	}

	@Override
	public List<Account> getAll() {
		// TODO Auto-generated method stub
		return accRepo.findAll();
		
	}

	@Override
	public void update(Account t) {
		// TODO Auto-generated method stub
		accRepo.save(t);
	}

	@Override
	public void deleteAccount(Integer ID) {
		// TODO Auto-generated method stub
       accRepo.deleteById(ID);
	}

	@Override
	public Optional<Account> getByIdentity(Integer ID) {
		// TODO Auto-generated method stub
		return accRepo.findById(ID);
	}

	


//	@Override
//	public void deposit(Integer accNo, float amount) {
//		// TODO Auto-generated method stub
//		//randomNumberGenerator = new RandomNumberGenerator();
//		//long tid = randomNumberGenerator.generateRandom(11);
//		
//		tr = new Transaction();
//		//timeStamp = getTimeStamp();
//		tr.setTransactionId(1001);
//		tr.setSourceAcc(accNo);
//		tr.setType("Credit");
//		tr.setAmount(amount);
//		//tr.setTimeStamp(timeStamp.toString());
//		accRepo.deposit(accNo, amount, tr);
//	}
//
//	@Override
//	public void withdraw(Integer accNo,float amount) {
//		// TODO Auto-generated method stub
//		tr = new Transaction();
//		//timeStamp = getTimeStamp();
//		tr.setTransactionId(1001);
//		tr.setSourceAcc(accNo);
//		tr.setType("Debit");
//		tr.setAmount(amount);
//		//tr.setTimeStamp(timeStamp.toString());
//		accRepo.withdraw(accNo, amount, tr);
//
//	}
//
//	@Override
//	public Map<String, Double> showBalance(Long accNo) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
