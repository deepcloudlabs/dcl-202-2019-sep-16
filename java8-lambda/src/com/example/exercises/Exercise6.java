package com.example.exercises;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.dao.CountryDao;
import com.example.dao.InMemoryWorldDao;
import com.example.domain.Country;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise6 {
	public static void main(String[] args) {
		CountryDao countryDao = 
				InMemoryWorldDao.getInstance();
		List<Country> countries = 
				countryDao.findAllCountries();
        List<String> continents =
	        countries.stream()
	                 .map(Country::getContinent)
	                 .distinct()
	                 .collect(Collectors.toList());
        System.out.println(continents);
        Map<String,Long> countryCountsByContinent = 
        		countries.stream()
                   .collect(Collectors.groupingBy(
                		     Country::getContinent,
                		     Collectors.counting()
                		   )
                   );
        System.out.println(countryCountsByContinent);
        Map<String,Optional<Country>> 
             maxPopulatedCountryOfEachContinent = 
        		countries.stream()
                   .collect(Collectors.groupingBy(
                		       Country::getContinent,
                		       Collectors.maxBy(
                		    	  Comparator.comparing(
                		    		Country::getPopulation
                		    	  )
                		       )
                		   )
                   );
        maxPopulatedCountryOfEachContinent.forEach(
        	(continent,country) -> 
        	   System.out.println(continent 
        			   + ": " 
        			   + country.get().getName() )
        );
	}
}







