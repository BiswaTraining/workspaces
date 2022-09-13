package com.citiustech.HibernateAssignment2OneTone;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.citiustech.HibernateAssignment2OneTone.model.Customer;
import com.citiustech.HibernateAssignment2OneTone.model.Locker;
import com.citiustech.HibernateAssignment2OneTone.util.HibernateUtil;



public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory sf=HibernateUtil.getSessionFactory();
        
 		Session session=sf.openSession();
 		Customer customer = new Customer();
 		customer.setCustomerName("Rahul");
 		customer.setAddress("Mumbai");
 		customer.setDateOfBirth(LocalDate.of(2007, 1, 13));
 		customer.setPhoneNumber("1234564324");
 		
 		Locker locker = new Locker();
 		locker.setLockerType("small");
 		locker.setRent(1100);
 		
 		customer.setLocker(locker);
 		session.beginTransaction();
 		session.save(customer);
 		session.getTransaction().commit();
 		session.close();
    }
}
