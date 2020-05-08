package com.example.wallet.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.wallet.bean.Account;
import com.example.wallet.bean.Transaction;
import com.example.wallet.exceptions.AccountException;
import com.example.wallet.repo.AccountRepository1;
import com.example.wallet.repo.TransactionRepository;

@Transactional
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository1 accRepo;
	
	private Transaction tr;

	@Autowired
	private TransactionRepository tranRep;
	@Override
	public Account add(Account t) {
		// create account method
		t.setAccountno(0);
		t.setOpeningdate(null);
		return accRepo.save(t);
		
	}

	@Override
	public List<Account> getAll() {
		// method to get the list of accounts
		return accRepo.findAll();
		
	}

	@Override
	public void update(Account t) throws AccountException{
		
		Account acc;
		try {
		 acc = accRepo.getOne( t.getAccountno());
		}
		catch(Exception e) {
			throw new AccountException(e.getMessage());
		}
		acc.setName(t.getName());
		acc.setAddress(t.getAddress());
		acc.setEmail(t.getEmail());
		acc.setPhoneno(t.getPhoneno());
		
		accRepo.save(t);
	}

	@Override
	public void deleteAccount(Long ID) {
		// TODO Auto-generated method stub
       accRepo.deleteById(ID);
	}

	@Override
	public Account getByIdentity(Long ID) {
		// TODO Auto-generated method stub
		return accRepo.getOne(ID);
	}

	


	@Override
	public void deposit(Long accNo,Long dest, float amount) {
		
		Account ac= new Account();
		ac=accRepo.getOne(accNo);
		ac.setBalance(ac.getBalance()+amount);
		System.err.println(""+ac);
		tr = new Transaction();
		
		tr.setTimeStamp(LocalDate.now().toString()+" "+LocalTime.now().toString());
		tr.setTransactionId(1001);
		tr.setSourceAcc(dest);
		tr.setDestAcc(accNo);
		tr.setType("Credit");
		tr.setAmount(amount);
		tr.setUpdatedBalance(ac.getBalance());
		tranRep.save(tr);
		System.err.println(tr);
		List<Transaction> list = ac.getTransactions();
		list.add(tr);
		ac.setTransactions(list);
		accRepo.save(ac);
	
		
		
	}

	@Override
	public void withdraw(Long accNo,Long dest,float amount) {
		
		System.err.println("in withdraw  "+accNo);
		Account ac= new Account();
		
		ac=accRepo.getOne(accNo);
		ac.setBalance(ac.getBalance()-amount);
		//accRepo.save(ac);
		tr = new Transaction();
		tr.setTimeStamp(LocalDate.now().toString()+" "+LocalTime.now().toString());
		tr.setTransactionId(1001);
		tr.setSourceAcc(accNo);
		tr.setDestAcc(dest);
		tr.setType("Debit");
		tr.setAmount(amount);
		tr.setUpdatedBalance(ac.getBalance());
		tranRep.save(tr);
		List<Transaction> list = ac.getTransactions();
		list.add(tr);
		ac.setTransactions(list);
		accRepo.save(ac);
		System.err.println("withdraw service");
	

	}

	@Override
	public void transfer(Long sAcc, Long destAcc, float amount) {
		// TODO Auto-generated method stub
		System.err.println("In transfer service");
		Account ac= new Account();
		ac=accRepo.getOne(destAcc);
		ac.setBalance(ac.getBalance()+amount);
		System.err.println(""+ac);
		tr = new Transaction();
		
		tr.setTimeStamp(LocalDate.now().toString()+" "+LocalTime.now().toString());
		tr.setTransactionId(1001);
		tr.setSourceAcc(sAcc);
		tr.setDestAcc(destAcc);
		tr.setType("Credit");
		tr.setAmount(amount);
		tr.setUpdatedBalance(ac.getBalance());
		tranRep.save(tr);
		System.err.println(tr);
		List<Transaction> list = ac.getTransactions();
		list.add(tr);
		ac.setTransactions(list);
		accRepo.save(ac);
		
		Account ac1= new Account();
		ac1=accRepo.getOne(sAcc);
		System.err.println(ac1);
		ac1.setBalance(ac1.getBalance()-amount);
		System.err.println(ac1);
		
		
	    tr.setType("Debit");
		
		tr.setUpdatedBalance(ac1.getBalance());
		
		List<Transaction> list1 = ac1.getTransactions();
		list.add(tr);
		ac1.setTransactions(list1);
		System.err.println(tr);
		
		accRepo.save(ac1);
		
		
	}


}
