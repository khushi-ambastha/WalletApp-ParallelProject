package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bean.Account;

@Repository
public interface AccountRepository1<AccountRepository1> extends JpaRepository<Account, Integer> {

}
