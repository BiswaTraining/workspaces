package com.citiustech.HibernateAssignment1;

import com.citiustech.HibernateAssignment1.dao.MovieDao;
import com.citiustech.HibernateAssignment1.model.Movie;

public class UserInterface {

	public static void main(String[] args) {
		Movie movie1 = new Movie();
		movie1.setMovieId("1");
		movie1.setMovieName("3 Idiots");
		movie1.setLanguage("Hindi");
		movie1.setReleasedIn(2010);
		movie1.setRevenueInDollars(200000);
		
		Movie movie2 = new Movie();
		movie2.setMovieId("2");
		movie2.setMovieName("Bahubali");
		movie2.setLanguage("Telegu");
		movie2.setReleasedIn(2017);
		movie2.setRevenueInDollars(400000);
		
		MovieDao.addMovie(movie1);
		MovieDao.addMovie(movie2);
		MovieDao.deleteMovie(movie2.getMovieId());
		MovieDao.updateMovie(movie1.getMovieId());
		MovieDao.getMovieDetails(movie1.getMovieId());
	}

}
