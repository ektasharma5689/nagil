package com.cg.banking.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int transactionId;
	private float amount;
	private String transacriotnType;
	@ManyToOne
	private Account account;
	public Transaction() {}
	public Transaction(float amount,String transactionType)
	{
		super();
		this.amount=amount;
		this.transacriotnType=transactionType;
	}
	public Transaction(int transactionId,float amount,String transactionType){
		super();
		this.transactionId=transactionId;
		this.transacriotnType=transactionType;
		this.amount=amount;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getTransacriotnType() {
		return transacriotnType;
	}
	public void setTransacriotnType(String transacriotnType) {
		this.transacriotnType = transacriotnType;
	}
}