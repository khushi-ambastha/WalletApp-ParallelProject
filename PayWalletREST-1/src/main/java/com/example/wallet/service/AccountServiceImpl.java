package com.example.wallet.service;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
		// TODO Auto-generated method stub
		t.setAccountno(0);
		t.setOpeningdate(null);
		return accRepo.save(t);
		
	}

	@Override
	public List<Account> getAll() {
		// TODO Auto-generated method stub
		return accRepo.findAll();
		
	}

	@Override
	public void update(Account t) throws AccountException{
		// TODO Auto-generated method stub
		//Account ac= new Account(t.setAccountno(),t.getBalance(),t.getOpeningdate(),t.getAccountName(),t.getPhoneno(),t.getDob(),t.getAddress(),t.getEmail(),t.getUsername(),t.getPassword());
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
	public void deposit(Long accNo, float amount) {
		
		Account ac= new Account();
		ac=accRepo.getOne(accNo);
		ac.setBalance(ac.getBalance()+amount);
		System.err.println(""+ac);
		tr = new Transaction();
		
		tr.setTimeStamp(LocalTime.now().toString());
		tr.setTransactionId(1001);
		tr.setSourceAcc(accNo);
		tr.setDestAcc(accNo);
		tr.setType("Credit");
		tr.setAmount(amount);
		tr.setUpdatedBalance(ac.getBalance());
		tranRep.save(tr);
		System.err.println(tr);
		List<Transaction> list = ac.getTransactions();
		list.add(tr);
		ac.setTransactions(list);
//		List<Transaction> list = ac.getTransactions();
//		list.add(tr);
//		ac.setTransactions(list);
		accRepo.save(ac);
		//ac.addTrans(tr);
		
		
		//accRepo.deposit(accNo, amount, tr);
	}

	@Override
	public void withdraw(Long accNo,float amount) {
		
		System.err.println("in withdraw");
		Account ac= new Account();
		ac=accRepo.getOne(accNo);
		ac.setBalance(ac.getBalance()-amount);
		//accRepo.save(ac);
		tr = new Transaction();
		tr.setTimeStamp(LocalTime.now().toString());
		tr.setTransactionId(1001);
		tr.setSourceAcc(accNo);
		tr.setDestAcc(accNo);
		tr.setType("Debit");
		tr.setAmount(amount);
		tr.setUpdatedBalance(ac.getBalance());
		tranRep.save(tr);
		List<Transaction> list = ac.getTransactions();
		list.add(tr);
		ac.setTransactions(list);
//		List<Transaction> list = ac.getTransactions();
//		list.add(tr);
//		ac.setTransactions(list);
		//ac.addTrans(tr);
		accRepo.save(ac);
		System.err.println("withdraw service");
		//accRepo.withdraw(accNo, amount, tr);

	}
//
//	@Override
//	public Map<String, Double> showBalance(Long accNo) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
