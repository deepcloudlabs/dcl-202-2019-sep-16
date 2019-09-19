package com.example.banking.app;

import java.util.Random;

import com.example.banking.entity.Account;
import com.example.banking.entity.CheckingAccount;
import com.example.banking.entity.InsufficientBalanceException;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class StudyPolymorphism {

	public static void main(String[] args) throws InsufficientBalanceException {
		Account acc;
		if (new Random().nextBoolean())
			acc = new Account("TR1", 1_000);
		else
			acc = new CheckingAccount("TR1", 1_000, 500);
		acc.withdraw(100_250);
		System.out.println(acc.getClass());
		System.out.println(acc.getBalance());

	}

}
