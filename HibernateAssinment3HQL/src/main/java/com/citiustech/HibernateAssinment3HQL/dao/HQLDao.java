package com.citiustech.HibernateAssinment3HQL.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.DistinctRootEntityResultTransformer;

import com.citiustech.HibernateAssinment3HQL.model.Hollywood;
import com.citiustech.HibernateAssinment3HQL.model.Movie;
import com.citiustech.HibernateAssinment3HQL.util.HibernateUtil;



public class HQLDao {
	public static SessionFactory sf=HibernateUtil.getSessionFactory();
	
	public static List<Movie> getMovieDetails(String language){
		return null;
	}
	public static List<Movie> getMoviesByDirector(Integer directorId){
		Session session=sf.openSession();
		Query query=session.createQuery("select m from Movie m where m.director="+directorId);
		List<Movie> movieList = query.getResultList();
		return movieList;
	}
	
	@Transactional
	public static void addMovie(Movie movie) {
		Session session=sf.openSession();		
		session.beginTransaction();
		session.save(movie);   //insert
		session.getTransaction().commit();
		Movie savedMovie=session.get(Movie.class, movie.getMovieId());
		session.close();
		if(movie.getLanguage().equalsIgnoreCase("ENGLISH")) {
			addMovieToHollywood(movie);
		}
	}
	
	public static void addMovieToHollywood(Movie movie) {
		Session session=sf.openSession();
		Hollywood hollywooodMovie = new Hollywood();
		hollywooodMovie.setLanguage(movie.getLanguage());
		hollywooodMovie.setMovieId(movie.getMovieId());
		hollywooodMovie.setMovieName(movie.getMovieName());
		hollywooodMovie.setReleasedIn(movie.getReleasedIn());
		hollywooodMovie.setRevenueInDollars(movie.getRevenueInDollars());
		session.beginTransaction();
		session.save(hollywooodMovie);   //insert
		session.getTransaction().commit();
		session.close();
	}
	
	public static void updateRevenue(Movie movie) {
		Session session=sf.openSession();		
		session.beginTransaction();

		Query q=session.createQuery("update Movie m set m.revenueInDollars = :revenueInDollars where m.movieId = :movieId");
		q.setParameter("revenueInDollars", movie.getRevenueInDollars()+100000);
		q.setParameter("movieId",movie.getMovieId());
		int status=q.executeUpdate();  
		System.out.println(status);  
		session.getTransaction().commit();
		session.close();
	}
	
	public static void deleteMovie(Movie movie) {

		Session session=sf.openSession();		
		session.beginTransaction();

		Query q=session.createQuery("delete Movie m where m.movieId = :movieId");
		q.setParameter("movieId",movie.getMovieId());
		int status=q.executeUpdate();  
		System.out.println(status);  
		session.getTransaction().commit();
		session.close();
	}
	
	public static List<String> getDistinctLanguages(){
		Session session=sf.openSession();		
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Movie.class);
		criteria.setProjection(Projections.distinct( Projections.property( "language")));
		List<String> languageList = criteria.list();
		for(String language:languageList) {
			System.out.println(language);
		}
		session.getTransaction().commit();
		session.close();
		return languageList;
	}
	
	public static List<Object[]> getRequiredFields(){
		Session session=sf.openSession();		
		session.beginTransaction();
		Query query= session.createQuery("select m.movieName, m.director.directorName from Movie m");
		List<Object[]> listOfObjects = query.getResultList();
		
		for(Object[] object : listOfObjects) {
			System.out.println("Movie name is "+object[0]+" and corresponding director name is "+object[1]);
		}
		session.getTransaction().commit();
		session.close();
		return listOfObjects;

	}
}
