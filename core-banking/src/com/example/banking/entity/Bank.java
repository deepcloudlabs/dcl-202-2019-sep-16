package com.example.banking.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public final class Bank {
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
}









