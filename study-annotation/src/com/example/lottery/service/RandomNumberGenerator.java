package com.example.lottery.service;

import java.lang.reflect.Field;
import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;

import com.example.lottery.model.RandomNumber;

/**
  * @author Binnur Kurt <binnur.kurt@gmail.com>
  *
  */
public class RandomNumberGenerator {
	public void generate(Object o) {
		Class<?> clazz = o.getClass();
		for (Field field : clazz.getDeclaredFields()) {
			if (field.isAnnotationPresent(RandomNumber.class)) {
				RandomNumber rn = 
						field.getAnnotation(RandomNumber.class);
				List<Integer> numbers =
						new SecureRandom().ints(rn.min(),rn.max())
				                  .distinct()
				                  .limit(rn.size())
				                  .sorted()
				                  .boxed()
				                  .collect(Collectors.toList());
				try {
					field.setAccessible(true);
					field.set(o, numbers);
					field.setAccessible(false);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}       
			}
		}
	}
}
