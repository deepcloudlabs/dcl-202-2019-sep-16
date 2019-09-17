package com.example.banking.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Customer {
	private final String identityNo;
	private String fullName;
	private List<Account> accounts;

	public Customer(String identityNo, String fullName) {
		this.identityNo = identityNo;
		this.fullName = fullName;
		this.accounts = new ArrayList<>();
	}

	public String getIdentityNo() {
		return identityNo;
	}

	public String getFullName() {
		return fullName;
	}

	public void addAccount(Account acc) {
       accounts.add(acc);		
	}
	public int getNumberOfAccounts() {
		return accounts.size();
	}
	public Account getAccount(int index) {
		return accounts.get(index);
	}
	public Optional<Account> getAccount(String iban) {
		for(Account acc: accounts) {
			if (acc.getIban().equals(iban))
				return Optional.of(acc);
		}
		return Optional.empty();
	}
	public Optional<Account> removeAccount(String iban) {
		Optional<Account> opt = getAccount(iban);
		opt.ifPresent( acc -> accounts.remove(acc));
		return opt;
	}

	@Override
	public String toString() {
		return "Customer [identityNo=" + identityNo + ", fullName=" + fullName + ", accounts=" + accounts + "]";
	}

	public double getTotalBalance() {
		double total = 0.;
		for (Account acc: accounts)
			total += acc.getBalance();
		return total;
	}
	
}







