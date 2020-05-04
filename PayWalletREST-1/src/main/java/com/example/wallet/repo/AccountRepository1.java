package com.example.wallet.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.wallet.bean.Account;
import com.example.wallet.bean.Transaction;

@Repository
public interface AccountRepository1 extends JpaRepository<Account, Long> {


	
	
}
