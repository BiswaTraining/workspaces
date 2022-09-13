package com.citiustech.HibernateAssignment1.dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.citiustech.HibernateAssignment1.model.Movie;
import com.citiustech.HibernateAssignment1.util.HibernateUtil;


public class MovieDao {
	public static SessionFactory sf=HibernateUtil.getSessionFactory();
	public static String addMovie(Movie movie) {
		Session session=sf.openSession();		
		session.beginTransaction();
		session.save(movie);   //insert
		session.getTransaction().commit();
		Movie savedMovie=session.get(Movie.class, movie.getMovieId());
		session.close(); 
		System.out.println(savedMovie);
		return savedMovie.getMovieId();
	}
	public static void deleteMovie(String  movieId) {
		Session session=sf.openSession();		
		session.beginTransaction();
		Query deleteq=session.createQuery("delete from  Movie m where m.movieId= "+movieId);
		deleteq.executeUpdate();
		session.close();
	}
	public static void updateMovie(String movieId) {
		Session session=sf.openSession();
		Movie movie = session.load(Movie.class, movieId);//NullPointerException, lazy ,faster, proxy object
		session.beginTransaction(); 
		movie.setRevenueInDollars(movie.getRevenueInDollars()+100000);
		session.saveOrUpdate(movie);
		session.getTransaction().commit();
		session.close(); 
	}
	public static Movie getMovieDetails(String movieId) {
		Session session=sf.openSession();
		Movie movie = session.load(Movie.class, movieId);
		System.out.println(movie);
		return movie;
	}
}
