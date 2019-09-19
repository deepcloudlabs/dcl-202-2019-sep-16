package com.example.exercises;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import com.example.dao.CountryDao;
import com.example.dao.InMemoryWorldDao;
import com.example.domain.Country;

/**
  * @author Binnur Kurt <binnur.kurt@gmail.com>
  *
  */
public class Exercise1 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		CountryDao countryDao = 
				InMemoryWorldDao.getInstance();
		List<Country> countries = 
				countryDao.findAllCountries();
		Predicate<Country> asianCountry =
				country -> country.getContinent()
				.equalsIgnoreCase("Asia");
		Comparator<Country> orderByPopulationAsc =
				(c1,c2) -> 
		        c1.getPopulation()-c2.getPopulation();
		Comparator<Country> orderByPopulationDesc =
				 orderByPopulationAsc.reversed();
		List<Country> asianCountries =
		       countries.stream()
		                .filter(asianCountry)
		                .sorted(
		                               comparing(Country::getPopulation)
		                .thenComparing(comparing(Country::getSurfaceArea))
		                 )
		                .collect(toList());
		asianCountries.forEach( 
				//country -> System.out.println(country)
				System.out::println
		);
		                
	}

}








