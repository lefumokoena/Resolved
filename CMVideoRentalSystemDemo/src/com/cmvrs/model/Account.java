package com.cmvrs.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tblAccount")
public class Account implements Serializable
{

	private static final long serialVersionUID = -7423100982956656340L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long accountId;
	
	@Column(name = "tblAccount_AccountType")
	private String accountType;
		
	@Column(name = "tblAccount_Balance")
	private double balance;
	
	@Column(name = "tblAccount_Owing")
	private double owing;
	
	@Column(name = "tblAccount_Status")
	private String status;
	
	//Relatioship
	
	@OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
	private Customer customer;
	
	//End Relationship
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	
	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	public double getOwing() {
		return owing;
	}

	public void setOwing(double owing) {
		this.owing = owing;
	}

	public Account() {
		
	}
	
}
