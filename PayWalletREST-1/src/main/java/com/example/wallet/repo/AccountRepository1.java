package com.example.wallet.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.wallet.bean.Account;


@Repository
public interface AccountRepository1 extends JpaRepository<Account, Long> {


	
	
}
