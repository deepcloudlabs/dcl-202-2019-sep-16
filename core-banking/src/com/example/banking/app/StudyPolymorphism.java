package com.example.banking.app;

import java.util.Random;

import com.example.banking.entity.Account;
import com.example.banking.entity.CheckingAccount;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class StudyPolymorphism {

	public static void main(String[] args) {
		Account acc;
		if (new Random().nextBoolean())
			acc = new Account("TR1", 1_000);
		else
			acc = new CheckingAccount("TR1", 1_000, 500);
		acc.withdraw(1_250);
		System.out.println(acc.getClass());
		System.out.println(acc.getBalance());

	}

}
