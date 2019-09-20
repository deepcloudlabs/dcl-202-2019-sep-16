package com.example.banking.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@SuppressWarnings("serial")
public class Customer implements Serializable {
	private final String identityNo;
	private String fullName;
	private List<Account> accounts;

	public Customer(final String identityNo,final String fullName) {
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

	public final void addAccount(Account acc) {
       accounts.add(acc);		
	}
	public final int getNumberOfAccounts() {
		return accounts.size();
	}
	public final Account getAccount(final int index) {
		return accounts.get(index);
	}
	public final Optional<Account> getAccount(final String iban) {
		for(Account acc: accounts) {
			if (acc.getIban().equals(iban))
				return Optional.of(acc);
		}
		return Optional.empty();
	}
	public final Optional<Account> removeAccount(final String iban) {
		Optional<Account> opt = getAccount(iban);
		opt.ifPresent( acc -> accounts.remove(acc));
		return opt;
	}

	@Override
	public String toString() {
		return "Customer [identityNo=" + identityNo + ", fullName=" + fullName + ", accounts=" + accounts + "]";
	}

	public final double getTotalBalance() {
		double total = 0.;
		for (Account acc: accounts)
			total += acc.getBalance();
		return total;
	}
	
}







