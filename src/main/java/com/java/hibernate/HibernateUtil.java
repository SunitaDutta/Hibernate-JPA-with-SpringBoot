package com.java.hibernate;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;

	private HibernateUtil() {
	}

	public static SessionFactory getSessionFactory() {

		if (sessionFactory == null) {
			System.out.println("count - null ");
			try {
				Configuration con = new Configuration().configure();
//				Properties pros = new Properties();
//				pros.put(Environment.DRIVER, "org.postgresql.Driver");
//				pros.put(Environment.URL, "jdbc:postgresql://localhost:5432/spring_jpa");
//				pros.put(Environment.USER, "postgres");
//				pros.put(Environment.PASS, "harman");
//				pros.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
//				pros.put(Environment.SHOW_SQL, "true");
//				pros.put(Environment.HBM2DDL_AUTO, "update");
//				con.setProperties(pros);
//				
//				con.addAnnotatedClass(Employee.class);
//				con.addAnnotatedClass(Company.class);
//				con.addAnnotatedClass(Department.class);
				

				ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties())
						.buildServiceRegistry();

				sessionFactory = con.buildSessionFactory(reg);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return sessionFactory;
	}

	public static Session getSession() {
		
		Session session = null;

		if (sessionFactory == null) {
			System.out.println("count - null ");
			try {
				Configuration con = new Configuration().configure();

				ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties())
						.buildServiceRegistry();

				sessionFactory = con.buildSessionFactory(reg);
				session = sessionFactory.openSession();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return session ;
	}

}
