package com.example.bean;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.persistence.Column;

//import javax.persistence.Column;

@Entity
@Table(name="WalletTable ")
public class Account implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//@GeneratedValue
	@Id
	private int accountno;
	@Column
	private float balance;
	@Column
	private LocalDate openingdate;
	@Column
	private String accountName;
	@Column
	private long phoneno;
	@Column
	private Date dob;
	@Column
	private String address;
	@Column
	private String email;
	
	@Column(unique=true)
	private String username;
	@Column(unique=true)
	private String password;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(int accountno, float balance, Date openingdate, String accountName, long phoneno, Date dob,
			String address, String email, String username, String password) {
		Random rand=new Random();
		this.accountno =  rand.nextInt(1000000000);
		this.balance = balance;
		Date d= new Date();
		this.openingdate = LocalDate.now();;
		this.accountName = accountName;
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
	public int getAccountno() {
		return accountno;
	}
	public void setAccountno(int accountno) {
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
		this.openingdate = openingdate;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
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
	@Override
	public String toString() {
		return "Account [accountno=" + accountno + ", balance=" + balance + ", openingdate=" + openingdate
				+ ", accountName=" + accountName + ", phoneno=" + phoneno + ", dob=" + dob + ", address=" + address
				+ ", email=" + email + "]";
	}
	
}

