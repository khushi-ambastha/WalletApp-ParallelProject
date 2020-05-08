package com.example.wallet.bean;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




@Entity
@Table(name="WalletTable", schema="hr")
@JsonIgnoreProperties({ "hibernateLazyInitializer" })
public class Account implements Serializable{
	
	/**
	 * @author Khushi Ambastha
	 * Purpose: Account class
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	private long accountno;
	@Column(length=20)
	private float balance;
	@Column
	private LocalDate openingdate;
	@Column
	private String name;
	@Column(length=10)
	private long phoneno;
	@Column
	private Date dob;
	@Column
	private String address;
	@Column
	private String email;
	
	@Column
	private String username;
	
	@Column
	private String password;
	

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="accountno")
	@JsonIgnore
	private List<Transaction> transactions = new ArrayList<Transaction>();

	public Account() {
		super();
		
	}
	public Account(long accountno, float balance, LocalDate openingdate, String name,long phoneno, Date dob,
			String address, String email, String username, String password) {
		Random rand=new Random();
		this.accountno =  rand.nextInt(1000000000);
		this.balance = balance;
		Date d= new Date();
		this.openingdate = LocalDate.now();
		this.name = name;
		this.phoneno = phoneno;
		this.dob = dob;
		this.address = address;
		this.email = email;
		this.username=username;
		this.password=password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getAccountno() {
		return accountno;
	}
	public void setAccountno(long accountno) {
		
		this.accountno = accountno;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public LocalDate getOpeningdate() {
		return openingdate;
	}
	public void setOpeningdate(LocalDate openingdate) {
		this.openingdate = LocalDate.now();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	@Override
	public String toString() {
		return "Account [accountno=" + accountno + ", balance=" + balance + ", openingdate=" + openingdate
				+ ", accountName=" + name + ", phoneno=" + phoneno + ", dob=" + dob + ", address=" + address
				+ ", email=" + email + ", username=" + username + ", password=" + password  + "]";
	}
	
	
}

