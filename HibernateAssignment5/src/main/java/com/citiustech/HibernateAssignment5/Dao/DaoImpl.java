package com.citiustech.HibernateAssignment5.Dao;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.citiustech.HibernateAssignment5.model.Asset;
import com.citiustech.HibernateAssignment5.model.Employee;
import com.citiustech.HibernateAssignment5.util.HibernateUtil;

public class DaoImpl {
	public static SessionFactory sf=HibernateUtil.getSessionFactory();
	
	@Transactional
	public static void insertAssetAndEmployeeToDatabase() {
		Session session=sf.openSession();
		session.beginTransaction();
		Asset asset = new Asset(5,15, 5000, "Pavilion", 55000, "Delhi");
		Employee employee = new Employee("Rishabh", 5,"Rishabh@123456789", asset);
		session.save(asset);
		session.save(employee);
		session.getTransaction().commit();
		session.close();
	}
	
	public static Asset getAssetById(Integer id) {
		Session session=sf.openSession();
		session.beginTransaction();
		Asset asset = session.get(Asset.class, id);
		System.out.println(asset);
		session.getTransaction().commit();
		session.close();
		return asset;
	}
	
	
	public static void getCostliestAsset() {
		Session session=sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("select MAX(a.assetPrice) from Asset a");
		System.out.println(query.getResultList());
		session.getTransaction().commit();
		session.close();
	}
	
	public static void countTotalNumberOfEmployees() {
		Session session=sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("select COUNT(*) from Employee");
		System.out.println(query.getResultList());
		session.getTransaction().commit();
		session.close();
	}
	
	public static void getEmployeeDetailsOrderByName() {
		Session session=sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Employee e Order by e.empName ASC");
		System.out.println(query.getResultList());
		session.getTransaction().commit();
		session.close();
	}
	
	public static void getEmployeeDetailsById(Integer employeeId) {
		Session session=sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM Employee e where e.empId=:employeeId");
		query.setParameter("employeeId", employeeId);
		System.out.println(query.getResultList());
		session.getTransaction().commit();
		session.close();
	}
	  
	
	public static void getAverageAssetPriceByAssetLocation() {
		Session session=sf.openSession();
		session.beginTransaction();
		TypedQuery query = session.getNamedQuery("findAveragePriceOfAssetByLocation");    
		System.out.println(query.getResultList());
		session.getTransaction().commit();
		session.close();
	}
	
	public static void updatePassword(Integer employeeId) {
		Session session=sf.openSession();
		session.beginTransaction();
		
		Query q=session.createQuery("update Employee e set e.password = :password where e.empId = :empId");
		q.setParameter("password", "Biswadeep09876@1234");
		q.setParameter("empId",employeeId);
		int status=q.executeUpdate();  
		System.out.println(status);
		session.getTransaction().commit();
		session.close();
	}
	
	
	
	public static void deleteEmployeeById(Integer employeeId) {
		Session session=sf.openSession();
		session.beginTransaction();
		Employee employee = session.get(Employee.class, employeeId);
		session.remove(employee);		 
		session.getTransaction().commit();
		session.close();
	}

	
}
