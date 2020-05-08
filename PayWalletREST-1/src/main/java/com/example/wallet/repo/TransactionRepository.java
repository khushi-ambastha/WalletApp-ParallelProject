package com.example.wallet.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.wallet.bean.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	
	
}
