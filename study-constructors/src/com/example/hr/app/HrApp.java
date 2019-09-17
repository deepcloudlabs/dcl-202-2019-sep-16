package com.example.hr.app;

import com.example.hr.domain.Language;
import com.example.hr.domain.SoftwareEngineer;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class HrApp {

	public static void main(String[] args) {
		// No-argument constructor
		// No-arg constructor
		// Default constructor
		SoftwareEngineer jack = new SoftwareEngineer("1", "Jack Bauer", 100_000, (short) 1956);
		jack.learnLanguage(new Language("Java", (byte) 10, true));
	}

}
