package com.example.exercises;

import java.util.Collection;

import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;

/**
  * @author Binnur Kurt <binnur.kurt@gmail.com>
  *
  */
public class Exercise2 {

	public static void main(String[] args) {
		MovieService movieSrv = 
				InMemoryMovieService.getInstance();
		Collection<Movie> movies = 
				movieSrv.findAllMovies();
		long count = movies.stream()
		      .filter(movie -> movie.getDirectors().size() > 1)
		      .count();
		
		count = movies.stream()
	      .map(Movie::getDirectors)
	      .map(Collection::size)
	      .filter( Exercise2::largerThan1 )
	      //.filter( i -> i > 1 )
	      .count();
		System.out.println(count);
	}
    public static boolean largerThan1(Integer i) { return i > 1; }  
}








