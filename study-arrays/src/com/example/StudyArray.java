package com.example;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class StudyArray {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int num = 42; // scalar
		// array
		int numbers[] = { 4, 8, 15, 16, 23, 42 };
		System.out.println(numbers.length);
		System.out.println(numbers[0]);
		System.out.println(numbers[5]);
		for (int i = 0; i < numbers.length; ++i)
			System.out.println(numbers[i]);
		for (int i = numbers.length - 1; i >= 0; --i)
			System.out.println(numbers[i]);
		// SE5: for-each
		for (int n : numbers)
			System.out.println(n);
	}

}
