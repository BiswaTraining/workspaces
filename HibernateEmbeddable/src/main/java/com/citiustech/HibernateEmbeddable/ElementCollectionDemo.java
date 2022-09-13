package com.citiustech.HibernateEmbeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.citiustech.HibernateEmbeddable.util.HibernateUtil;

public class ElementCollectionDemo {
public static void main(String[] args) {
	SessionFactory sf=HibernateUtil.getSessionFactory();
	Session session=sf.openSession();  // insert,delete,update,get 
	
	session.beginTransaction();  //insert, delete,update 
	
    Employee emp = new Employee();
    emp.setName("Ram");
    
    VacationEntry v = new VacationEntry();
    v.setDaysTaken(10);
    VacationEntry v1 = new VacationEntry();
    v1.setDaysTaken(15);
    emp.getVacationBookings().add(v1);
    emp.getVacationBookings().add(v);
    emp.getNickNames().add("Tester");
    emp.getNickNames().add("QA");
    
	
	session.save(emp);
	session.getTransaction().commit();
	session.close();       //4 detached 
	
	
}
}
