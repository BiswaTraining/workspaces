package com.citiustech.HibernateAssinment3HQL;

import java.util.List;

import com.citiustech.HibernateAssinment3HQL.dao.HQLDao;
import com.citiustech.HibernateAssinment3HQL.model.Director;
import com.citiustech.HibernateAssinment3HQL.model.Movie;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Movie movie1 = new Movie();
        movie1.setMovieName("Gravity");
        movie1.setLanguage("English");
        movie1.setReleasedIn(2014);
        movie1.setRevenueInDollars(1000000);
        
        Director director= new Director();
        director.setDirectorName("Christopher Nolan");
        director.setBornIn(1975);
        
        movie1.setDirector(director);
        
        
        Movie movie2 = new Movie();
        movie2.setMovieId(19);
        movie2.setMovieName("Newton");
        movie2.setLanguage("Hindi");
        movie2.setReleasedIn(2018);
        movie2.setRevenueInDollars(1500000);
        
        Director director2= new Director();
        director2.setDirectorName("Rajkumar Hirani");
        director2.setBornIn(1975);
        
        movie2.setDirector(director2);
        
        HQLDao.addMovie(movie1);
        HQLDao.addMovie(movie2);
    	List<Movie> movies = HQLDao.getMoviesByDirector(18);
    	for(Movie movie:movies) {
    		System.out.println(movie);
    	}
    	
    	HQLDao.updateRevenue(movie2);
//    	HQLDao.deleteMovie(movie2);
    	
    	HQLDao.getDistinctLanguages();
    	HQLDao.getRequiredFields();
        
    }
}
