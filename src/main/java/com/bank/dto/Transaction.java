package com.bank.dto;

import java.time.LocalDateTime;

public class Transaction {

	private int id;
	private int userId;
	private String type; // deposit, withdraw, transfer_in, transfer_out
	private double amount;
	private LocalDateTime date;
	private String referenceAccount; // for transfer operations

	// Default Constructor
	public Transaction() {
	}

	// Constructor without id (for insert)
	public Transaction(int userId, String type, double amount, LocalDateTime date, String referenceAccount) {
		this.userId = userId;
		this.type = type;
		this.amount = amount;
		this.date = date;
		this.referenceAccount = referenceAccount;
	}

	// Full Constructor
	public Transaction(int id, int userId, String type, double amount, LocalDateTime date, String referenceAccount) {
		this.id = id;
		this.userId = userId;
		this.type = type;
		this.amount = amount;
		this.date = date;
		this.referenceAccount = referenceAccount;
	}

	// Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getReferenceAccount() {
		return referenceAccount;
	}

	public void setReferenceAccount(String referenceAccount) {
		this.referenceAccount = referenceAccount;
	}
}
