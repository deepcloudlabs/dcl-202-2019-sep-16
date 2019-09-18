package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
  * @author Binnur Kurt <binnur.kurt@gmail.com>
  *
  */
public class StudyList {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
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
		System.out.println(numbers.get(0)); 
		System.out.println(numbers.get(3)); 
		System.out.println(numbers.get(numbers.size()-1));
		numbers.add(0,108);
		System.out.println(numbers); 
		Collections.sort(numbers,
			(o1,o2) -> o2-o1
		);
		System.out.println(numbers); 		
	}

}

class SortOrderDesc implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		return o2-o1;
	}
	
}















