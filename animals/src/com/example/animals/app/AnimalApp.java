package com.example.animals.app;

import java.util.Arrays;
import java.util.List;

import com.example.animals.domain.Animal;
import com.example.animals.domain.Cat;
import com.example.animals.domain.Fish;
import com.example.animals.domain.Pet;
import com.example.animals.domain.Spider;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class AnimalApp {

	public static void main(String[] args) {
		List<Animal> animals = Arrays.asList(new Fish("Free Willy"), new Spider(), new Cat("Garfield"), new Spider(),
				new Cat(), new Fish("Jaws"));
		for (Animal animal : animals) {
			animal.walk();
			animal.eat();
			if (animal instanceof Pet) {
				((Pet) animal).play();
			}
		}
		int totalLegs = 0;
		for (Animal animal : animals) {
			totalLegs += animal.getLegs();
		}
		System.out.println("Total legs: "+totalLegs);
		totalLegs = animals.stream()
				           .mapToInt(Animal::getLegs)
				           .sum(); 
		System.out.println("Total legs: "+totalLegs);
		animals.stream().filter( animal -> animal instanceof Pet)
		           .map( animal -> (Pet) animal)
		           .filter( pet -> pet.getName().equals("Jaws"))
		           .findFirst()
		           .ifPresent(System.out::println);
		
	}

}
