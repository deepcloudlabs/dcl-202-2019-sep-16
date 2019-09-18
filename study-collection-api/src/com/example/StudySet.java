package com.example;

import java.util.Set;
import java.util.TreeSet;

/**
  * @author Binnur Kurt <binnur.kurt@gmail.com>
  *
  */
public class StudySet {

	public static void main(String[] args) {
		Set<Integer> numbers = new TreeSet<>((o1,o2)->o2-o1);
		numbers.add(42);
		numbers.add(4);
		numbers.add(42);
		numbers.add(23);
		numbers.add(42);
		numbers.add(8);
		numbers.add(15);
		numbers.add(16);
		numbers.add(15);
		System.out.println(numbers); 		
	}

}















