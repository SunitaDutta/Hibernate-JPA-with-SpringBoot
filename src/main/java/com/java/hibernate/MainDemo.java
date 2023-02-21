package com.java.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MainDemo {

	public static void main(String[] args) {
		
		
		
		
//		Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).addAnnotatedClass(Company.class);
//		
//		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
//
//		 SessionFactory sessionFactory = configuration.buildSessionFactory(reg);
//		 Session session = sessionFactory.openSession();
//		 
//		 Transaction tx = session.beginTransaction();
//		 
//		 session.get(Employee.class,1);
//		 
//		 tx.commit();
//		
//		
//		
//		Company company = new Company("TCS", "Kolkata");
//		CompanyDAO companyDAO = new CompanyDAO();
		//companyDAO.saveCompany(company);
		
		Employee emp = new Employee("Harman",100000);
		EmployeeDAO empdao = new EmployeeDAO();
//		
//		empdao.saveEmployee(emp);
//		empdao.getEmployee(1);
		
//		Department dept = new Department("HR", "Hiring");
//		DepartmentDAO departmentDAO = new DepartmentDAO();
		//departmentDAO.saveDepartment(dept);
		
		
//		 System.out.println(empdao.getEmployee(1));
//		 System.out.println(empdao.getEmployee(1));
//		 System.out.println(empdao.getEmployee(1));
		
		System.out.println("jk");
		 
	}

}
