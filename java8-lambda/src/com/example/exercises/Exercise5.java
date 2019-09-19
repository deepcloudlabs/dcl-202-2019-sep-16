package com.example.exercises;

import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;

/**
  * @author Binnur Kurt <binnur.kurt@gmail.com>
  *
  */
public class Exercise5 {

	public static void main(String[] args) {
		List<Integer> numbers = 
		new SecureRandom().ints(1, 50)
		                  .distinct()
		                  .limit(6)
		                  .sorted()
		                  .boxed()
		                  .collect(Collectors.toList());
		System.out.println(numbers);
	}

}




