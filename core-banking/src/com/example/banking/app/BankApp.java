package com.example.banking.app;

import com.example.banking.entity.Account;
import com.example.banking.entity.Bank;
import com.example.banking.entity.CheckingAccount;
import com.example.banking.entity.Customer;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class BankApp {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Bank garanti = new Bank(1, "Garanti BBVA");
		Customer jack = garanti.createCustomer("1", "Jack Bauer");
		jack.addAccount(new Account("TR1", 1_000));
		jack.addAccount(new CheckingAccount("TR2", 2_000, 500));
		jack.addAccount(new Account("TR3", 3_000));
		jack.getAccount("TR2").ifPresent(account -> account.withdraw(1_500));
		Customer kate = garanti.createCustomer("2", "Kate Austen");
		kate.addAccount(new CheckingAccount("TR4", 4_000, 1_500));
		kate.addAccount(new Account("TR5", 5_000));
		kate.addAccount(new CheckingAccount("TR6", 6_000, 1_000));
		double totalBalance = garanti.getTotalBalance();
		System.out.println("Total balance: " + totalBalance);
	}
}
