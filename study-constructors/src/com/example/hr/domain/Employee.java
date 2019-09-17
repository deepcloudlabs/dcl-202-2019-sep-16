package com.example.hr.domain;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Employee {
	private final String identity;
	private String fullname;
	private double salary;
	private final short birthYear;

	public Employee(String identity, String fullname, double salary, short birthYear) {
		this.identity = identity;
		this.fullname = fullname;
		this.salary = salary;
		this.birthYear = birthYear;
	}

	public String getIdentity() {
		return identity;
	}

	public String getFullname() {
		return fullname;
	}

	public double getSalary() {
		return salary;
	}

	public short getBirthYear() {
		return birthYear;
	}

	public void increaseSalary(double rate) {
		this.salary *= (1. + rate);
	}

	@Override
	public String toString() {
		return "Employee [identity=" + identity + ", fullname=" + fullname + ", salary=" + salary + ", birthYear="
				+ birthYear + "]";
	}

}
