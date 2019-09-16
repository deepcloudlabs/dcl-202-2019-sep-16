package com.example.banking.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AccountTest {

	@Test
	void deposit_negativeAmount() {
		Account acc = new Account("TR1", 1_000);
		assertEquals("TR1", acc.getIban());
		assertEquals("Account [iban=TR1, balance=1000.0]", acc.toString());
		assertFalse(acc.deposit(-1));
		assertEquals(1_000, acc.getBalance(), 0.001);
	}
	
	@Test
	void deposit_positiveAmount() {
		Account acc = new Account("TR1", 1_000);
		assertTrue(acc.deposit(1));
		assertEquals(1_001, acc.getBalance(), 0.001);
	}
	
	@Test
	void withdraw_negativeAmount() {
		Account acc = new Account("TR1", 1_000);
		assertFalse(acc.withdraw(-1));
		assertEquals(1_000, acc.getBalance(), 0.001);
	}

	@Test
	void withdraw_overAmount() {
		Account acc = new Account("TR1", 1_000);
		assertFalse(acc.withdraw(1_001));
		assertEquals(1_000, acc.getBalance(), 0.001);
	}
	
	@Test
	void withdraw_all() {
		Account acc = new Account("TR1", 1_000);
		assertTrue(acc.withdraw(1_000));
		assertEquals(0, acc.getBalance(), 0.001);
	}

}
