package com.example.banking.entity;

import java.io.Serializable;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@SuppressWarnings("serial")
public class Account implements Serializable{
	// attribute, field, state
	// instance variable
	private static int numOfAccounts;
	private final String iban;
	protected double balance;
	protected AccountStatus status = AccountStatus.ACTIVE;

	// constructor
	public Account(String iban, double balance) {
		this.iban = iban;
		this.balance = balance;
		numOfAccounts++;
	}

	public static int getNumOfAccounts() {
		return numOfAccounts;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	public String getIban() {
		return iban;
	}

	public double getBalance() {
		return balance;
	}

	// business method
	public void withdraw(double amount) throws InsufficientBalanceException {
		// validation
		if (amount <= 0)
			throw new IllegalArgumentException(
					"amount must be positive!");
		// business rule
		if (amount > balance)
			throw new InsufficientBalanceException(
					"Your balance does not cover your expenses!",
					amount-balance);
		// shortcut:
		// balance = balance - amount;
		balance -= amount; // business logic
	}

	public void deposit(double amount) {
		// validation
		if (amount <= 0)
			throw new IllegalArgumentException(
					                 "amount must be positive!");
		balance += amount; // business logic
	}

	@Override
	public String toString() {
		return "Account [iban=" + iban + ", balance=" + balance + "]";
	}

}