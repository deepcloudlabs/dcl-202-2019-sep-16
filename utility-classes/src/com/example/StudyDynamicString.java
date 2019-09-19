package com.example;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class StudyDynamicString {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		String name = "Jack"; // static string
		// StringBuffer: Thread Safe?
		StringBuilder dynamic = new StringBuilder();
		long start = System.currentTimeMillis();
		for (int i = 0; i < 20_000_000; ++i)
			dynamic.append(Integer.toString(i));
		long stop = System.currentTimeMillis();
		System.out.println(dynamic.length());
		System.out.println("Duration: " + (stop - start) + " ms.");
	}

}
