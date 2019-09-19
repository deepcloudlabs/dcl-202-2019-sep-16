package com.example.exercises;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.example.domain.Director;
import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;

/**
  * @author Binnur Kurt <binnur.kurt@gmail.com>
  *
  */
public class Exercise4 {

	public static void main(String[] args) {
		MovieService movieSrv = 
				InMemoryMovieService.getInstance();
		Collection<Movie> movies = 
				movieSrv.findAllMovies();
		Map<String,Long> directorsMovieCounts =
				movies.stream()
		           .map(Movie::getDirectors)
		           .flatMap(List::stream)
		           .collect(
		        		   Collectors.groupingBy(
		        				Director::getName,
		        			    Collectors.counting()
		        		  )
		          );
		System.out.println("Second solution:");
		Comparator<Entry<String, Long>> orderByMovieCountAsc = 
				Comparator.comparing(Entry::getValue);
		directorsMovieCounts.entrySet()
						    .stream()
		                    .sorted(orderByMovieCountAsc.reversed())
		                    .forEach( entry -> System.out.println(
		    						entry.getKey()
		    						+ " : "
		    						+ entry.getValue() ) 
		    				);
		directorsMovieCounts.entrySet()
		.forEach(
				entry -> System.out.println(
						entry.getKey()
						+ " : "
						+ entry.getValue() 
						)
				);
		Comparator<DirectorStatistics> orderByCount = Comparator.comparing(DirectorStatistics::getCount);
		List<DirectorStatistics> statistics = directorsMovieCounts.entrySet()
		                .stream()
		                .map(entry -> 
		                   new DirectorStatistics(entry.getKey(),entry.getValue())
		                ).sorted(orderByCount.reversed())
		                .collect(Collectors.toList());
		statistics.forEach(System.out::println);
	}

}

class DirectorStatistics {
	private final String director;
	private final long count;
	public DirectorStatistics(String director, long count) {
		this.director = director;
		this.count = count;
	}
	public String getDirector() {
		return director;
	}
	public long getCount() {
		return count;
	}
	@Override
	public String toString() {
		return "DirectorStatistics [director=" + director + ", count=" + count + "]";
	}
	
}




