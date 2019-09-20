package com.example.banking.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.banking.service.TransferService;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@SuppressWarnings("serial")
public final class Bank implements TransferService,Serializable {
	private final int id;
	private String name;
	private List<Customer> customers;
	private Map<String, Customer> customerMap;

	public Bank(final int id, final String name) {
		this.id = id;
		this.name = name;
		customers = new ArrayList<>();
		customerMap = new HashMap<>();
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public Customer createCustomer(final String identityNo, final String fullName) {
		Customer cust = new Customer(identityNo, fullName);
		customers.add(cust);
		customerMap.put(identityNo, cust);
		return cust;
	}

	public Customer getCustomer(final int index) {
		return customers.get(index);
	}

	public Optional<Customer> getCustomer(final String identityNo) {
//		for (Customer cust : customers) {
//			if (cust.getIdentityNo().equals(identityNo))
//				return Optional.of(cust);
//		}
//		return Optional.empty();
//		return customers.stream()
//		        .filter(cust -> cust.getIdentityNo()
//		        		            .equals(identityNo))
//		        .findFirst();
		return Optional.ofNullable(customerMap.get(identityNo));
	}

	public int getNumberOfCustomers() {
		return customers.size();
	}

	public double getTotalBalance() {
//		double total= 0.;
//		for (Customer cust : customers) {
//			total += cust.getTotalBalance();
//		}			
//		return total;
		return customers.stream().mapToDouble(Customer::getTotalBalance).sum();
	}

	@Override
	public void transfer(String fromIban, String toIban, double amount) throws InsufficientBalanceException {
		Account from = getAccount(fromIban);
		Account to = getAccount(toIban);
		from.withdraw(amount);
		to.deposit(amount);
	}

	public Account getAccount(String iban) {
		for (Customer customer : customers) {
			Optional<Account> account = customer.getAccount(iban);
			if (account.isPresent())
				return account.get();
		}
		throw new IllegalArgumentException("Cannot find account!");
	}
}
