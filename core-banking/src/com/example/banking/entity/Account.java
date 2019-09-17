package com.example.banking.entity;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Account {
	// attribute, field, state
	// instance variable
	private final String iban;
    double balance;

	// constructor
	public Account(String iban, double balance) {
		this.iban = iban;
		this.balance = balance;
	}

	public String getIban() {
		return iban;
	}

	public double getBalance() {
		return balance;
	}

	// business method
	public boolean withdraw(double amount) {
		System.out.println("Account::withdraw");
		// validation
		if (amount <= 0)
			return false;
		// business rule
		if (amount > balance)
			return false;
		// shortcut:
		// balance = balance - amount;
		balance -= amount; // business logic
		return true;
	}

	public boolean deposit(double amount) {
		// validation
		if (amount <= 0)
			return false;
		balance += amount; // business logic
		return true;
	}

	@Override
	public String toString() {
		return "Account [iban=" + iban + ", balance=" + balance + "]";
	}

}