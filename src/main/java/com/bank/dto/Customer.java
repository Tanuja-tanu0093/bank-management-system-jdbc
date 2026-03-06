package com.bank.dto;

public class Customer {

	private int id;
	private String accountNumber;
	private String name;
	private String email;
	private String pin;
	private double balance;

	// Default Constructor
	public Customer() {
	}

	// Constructor without id (for registration)
	public Customer(String accountNumber, String name, String email, String pin, double balance) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.email = email;
		this.pin = pin;
		this.balance = balance;
	}

	// Constructor with all fields
	public Customer(int id, String accountNumber, String name, String email, String pin, double balance) {
		this.id = id;
		this.accountNumber = accountNumber;
		this.name = name;
		this.email = email;
		this.pin = pin;
		this.balance = balance;
	}

	// Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
