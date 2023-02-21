package com.java.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployeeDAO {

	Transaction transaction = null;
	Session session = null;

	public EmployeeDAO() {
		
	}

	public void saveEmployee(Employee employee) {

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(employee);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}

	public Employee getEmployee(int id) {

		Employee emp = null;

		try {
			//SessionFactory sf = HibernateUtil.getSessionFactory();
			//System.out.println(sf.hashCode());
			session = HibernateUtil.getSession();
			System.out.println(session.hashCode());
			transaction = session.beginTransaction();
			emp = (Employee) session.get(Employee.class, id);

			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return emp;
	}

}
