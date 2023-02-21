package com.java.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CompanyDAO {

	Transaction transaction = null;
	Session session = null;

	public CompanyDAO() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	public void saveCompany(Company company) {

		try {

			transaction = session.beginTransaction();
			session.save(company);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}

	public Company getCompany(int id) {

		Company com = null;

		try {

			transaction = session.beginTransaction();
			com = (Company) session.get(Company.class, id);

			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return com;
	}

}
