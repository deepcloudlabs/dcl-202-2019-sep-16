package com.example.exercises;

import static java.util.Comparator.comparing;

import java.util.Collection;

import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;

/**
  * @author Binnur Kurt <binnur.kurt@gmail.com>
  *
  */
public class Exercise3 {

	public static void main(String[] args) {
		MovieService movieSrv = 
				InMemoryMovieService.getInstance();
		Collection<Movie> movies = 
				movieSrv.findAllMovies();
		movies.stream()
		      .sorted(
		                  comparing(Movie::getYear )
 		  .thenComparing( comparing(Movie::getTitle) )
		      ).forEach(System.out::println);
	}

}






