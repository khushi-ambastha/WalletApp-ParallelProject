package com.example.wallet.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.wallet.bean.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	
	
}
