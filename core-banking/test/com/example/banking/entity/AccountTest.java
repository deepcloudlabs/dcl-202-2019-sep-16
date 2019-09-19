package com.example.banking.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class AccountTest {

	@Test
	void deposit_negativeAmount() throws Throwable {
		Account acc = new Account("TR1", 1_000);
		assertEquals("TR1", acc.getIban());
		assertEquals("Account [iban=TR1, balance=1000.0]", acc.toString());
		assertThrows(IllegalArgumentException.class, () -> acc.deposit(-1));
		assertEquals(1_000, acc.getBalance(), 0.001);
	}

	@Test
	void deposit_positiveAmount() throws Throwable {
		Account acc = new Account("TR1", 1_000);
		acc.deposit(1);
		assertEquals(1_001, acc.getBalance(), 0.001);
	}

	@Test
	void withdraw_negativeAmount() throws Throwable {
		Account acc = new Account("TR1", 1_000);
		assertThrows(IllegalArgumentException.class, () -> acc.withdraw(-1));
		assertEquals(1_000, acc.getBalance(), 0.001);
	}

	@Test
	void withdraw_overAmount() throws Throwable {
		Account acc = new Account("TR1", 1_000);
		assertThrows(InsufficientBalanceException.class, () -> acc.withdraw(1_001));
		assertEquals(1_000, acc.getBalance(), 0.001);
	}

	@Test
	void withdraw_all() throws Throwable {
		Account acc = new Account("TR1", 1_000);
		acc.withdraw(1_000);
		assertEquals(0, acc.getBalance(), 0.001);
	}

}
