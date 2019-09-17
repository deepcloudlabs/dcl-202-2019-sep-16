package com.example.hr.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class SoftwareEngineer extends Employee {
	private List<Language> languages;

	public SoftwareEngineer(String identity, String fullname, double salary, short birthYear) {
		super(identity, fullname, salary, birthYear);
		this.languages = new ArrayList<>();
	}

	public List<Language> getLanguages() {
		return Collections.unmodifiableList(languages);
	}

	public void learnLanguage(Language language) {
		languages.add(language);
	}
}
