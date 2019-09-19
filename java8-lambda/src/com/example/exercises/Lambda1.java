package com.example.exercises;

import com.example.dao.InMemoryWorldDao;
import com.example.dao.WorldDao;
import com.example.domain.City;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * @author Binnur Kurt (binnur.kurt@gmail.com)
 */
public class Lambda1 {

    public static void main(String[] args) {
        WorldDao worldDao = InMemoryWorldDao.getInstance();
        for (City city : worldDao.findAllCities()) {
            System.err.println(city.getName());
        }
        Iterator<City> iter = worldDao.findAllCities().iterator();
        while (iter.hasNext()) {
            City city = iter.next();
            System.err.println(city.getName());
        }
        List<City> allCities=worldDao.findAllCities();
        allCities.forEach(
          new Consumer<City>(){

            @Override
            public void accept(City city) {
                System.out.println(city.getName());
            }
          
          }
        );
        allCities.forEach( 
           (City city) -> { System.out.println(city); }        
        );
        allCities.forEach( 
        		(city) -> { System.out.println(city); }        
        		);
        allCities.forEach( 
        		city -> { System.out.println(city); }        
        );
        allCities.forEach( 
        		city -> System.out.println(city)        
        		);
        allCities.forEach(System.out::println);
    }
}
