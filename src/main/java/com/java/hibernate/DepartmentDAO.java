package com.java.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DepartmentDAO {

	Transaction transaction = null;
	Session session = null;

	public DepartmentDAO() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	public void saveDepartment(Department department) {

		try {

			transaction = session.beginTransaction();
			session.save(department);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}

	public Department getDepartment(int id) {

		Department dep = null;

		try {

			transaction = session.beginTransaction();
			dep = (Department) session.get(Department.class, id);

			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return dep;
	}

}
