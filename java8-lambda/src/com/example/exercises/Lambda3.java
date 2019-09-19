package com.example.exercises;

/**
 *
 * @author Binnur Kurt (binnur.kurt@gmail.com)
 */
public class Lambda3 {
	public static void main(String[] args) {
		Runnable task1 = () -> {
			System.err.println("Hello Mars!");
		};
		new Thread(task1).start();
		System.err.println("Hello Moon!");
	}
}
