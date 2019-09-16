package com.example.banking.app;

import com.example.banking.entity.Account;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class BankApp {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// Local variable
		// Reference Variable
		Account acc;
		// Local variable
		// Value-typed variable
		int x = 42;

		acc = new Account("TR1", 1_000);
		System.out.println(acc.getBalance());
		acc.deposit(250);
		System.out.println(acc.getBalance());
		acc.withdraw(750);
		System.out.println(acc.getBalance());
		acc.withdraw(1_000_000);
		System.out.println(acc.toString());
	}
}
