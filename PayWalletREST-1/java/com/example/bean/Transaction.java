package com.example.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Transactions")
public class Transaction {
	@Id
	@Column(name = "TransId", length = 12)
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long transactionId;
	@Column
	private long sourceAcc;
	@Column
	private long destAcc;
	@Column
	private String type;
	@Column
	private double amount;
	@Column
	private String timeStamp;
	@Column
	private double updatedBalance;
	public long getTransactionId() {
		return transactionId;
	}
	
	
	public Transaction(long transactionId, long sourceAcc, long destAcc, String type, double amount, String timeStamp,
			double updatedBalance) {
		super();
		this.transactionId = transactionId;
		this.sourceAcc = sourceAcc;
		this.destAcc = destAcc;
		this.type = type;
		this.amount = amount;
		this.timeStamp = timeStamp;
		this.updatedBalance = updatedBalance;
	}


	public long getSourceAcc() {
		return sourceAcc;
	}
	public void setSourceAcc(long sourceAcc) {
		this.sourceAcc = sourceAcc;
	}
	public long getDestAcc() {
		return destAcc;
	}
	public void setDestAcc(long destAcc) {
		this.destAcc = destAcc;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public double getUpdatedBalance() {
		return updatedBalance;
	}
	public void setUpdatedBalance(double updatedBalance) {
		this.updatedBalance = updatedBalance;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	
	
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", sourceAcc=" + sourceAcc + ", destAcc=" + destAcc
				+ ", type=" + type + ", amount=" + amount + ", timeStamp=" + timeStamp + ", updatedBalance="
				+ updatedBalance + "]";
	}
	
}