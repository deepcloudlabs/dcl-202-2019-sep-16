package com.example;

import java.util.Properties;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class StudyProperty {
	public static void main(String[] args) {
		Properties properties = System.getProperties();
		String lang = properties.getProperty("user.language");
		String country = properties.getProperty("user.country");
		System.out.println(lang+":"+country);
		for (Object key : properties.keySet()) {
			System.out.println(key + ": "+properties.getProperty(key.toString()));
		}
	}
}
