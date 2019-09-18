package com.example.banking.entity;

import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.banking.service.TransferService;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public final class Bank implements TransferService {
	private final int id;
	private String name;
	private List<Customer> customers;

	public Bank(final int id,final String name) {
		this.id = id;
		this.name = name;
		customers = new ArrayList<>();
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

	public Customer createCustomer(final String identityNo,final String fullName) {
		Customer cust = new Customer(identityNo, fullName);
		customers.add(cust);
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
		return customers.stream()
		        .filter(cust -> cust.getIdentityNo()
		        		            .equals(identityNo))
		        .findFirst();
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
		return customers.stream()
				        .mapToDouble(Customer::getTotalBalance)
				        .sum();
	}

	@Override
	public boolean transfer(String fromIban, String toIban, double amount) {
		Account from=getAccount(fromIban);
		if (isNull(from)) return false;
		Account to=getAccount(toIban);
		if (isNull(to)) return false; 
		if (from==to) return false;
		if( from.withdraw(amount) ) {
			return to.deposit(amount);
		} 
		return false;
	}
	public Account getAccount(String iban) {
		for (Customer customer : customers) {
		    Optional<Account> account = 
				customer.getAccount(iban);
		    if (account.isPresent())
		    	return account.get();
		}
		return null;
	}
}









