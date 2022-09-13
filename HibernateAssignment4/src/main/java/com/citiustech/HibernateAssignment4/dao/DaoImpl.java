package com.citiustech.HibernateAssignment4.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.citiustech.HibernateAssignment4.util.HibernateUtil;


public class DaoImpl {
	public static SessionFactory sf=HibernateUtil.getSessionFactory();
	
	public static void findMaximumRevenue(){
		Session session=sf.openSession();
		session.beginTransaction();
		Query query=session.createQuery("SELECT MAX(m.revenueInDollars) FROM Movie m");
		System.out.println(query.getResultList());
		session.getTransaction().commit();
		session.close();
	}
	
	public static void findMinimumRevenue(){
		Session session=sf.openSession();
		session.beginTransaction();
		Query query=session.createQuery("SELECT MIN(m.revenueInDollars) FROM Movie m");
		System.out.println(query.getResultList());
		session.getTransaction().commit();
		session.close();
	}
	
	public static void sumOfRevenue(){
		Session session=sf.openSession();
		session.beginTransaction();
		Query query=session.createQuery("SELECT SUM(m.revenueInDollars) FROM Movie m");
		System.out.println(query.getResultList());
		session.getTransaction().commit();
		session.close();
	}
	
	public static void averageRevenue(){
		Session session=sf.openSession();
		session.beginTransaction();
		Query query=session.createQuery("SELECT AVG(m.revenueInDollars) FROM Movie m");
		System.out.println(query.getResultList());
		session.getTransaction().commit();
		session.close();
	}
	
	public static void getNumberOfMoviesInAParticularLanguage(String language) {
		Session session=sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("SELECT COUNT(*) FROM Movie m where m.language=:language");
		query.setParameter("language", language);
		System.out.println(query.getResultList());
		session.getTransaction().commit();
		session.close();
	}
	
	public static void getNumberOfMoviesInEachLanguage() {
		Session session=sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("SELECT COUNT(*) FROM Movie m GROUP BY m.language");
		System.out.println(query.getResultList());
		session.getTransaction().commit();
		session.close();
	}
}
