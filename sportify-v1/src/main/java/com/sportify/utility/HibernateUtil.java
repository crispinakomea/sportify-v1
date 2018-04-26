package com.sportify.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Crispin A.
 *
 */
public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	private static final Logger logger = LogManager.getLogger(HibernateUtil.class);

	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable e) {
			logger.error("SessionFactory creation failed. (" + e + ")");
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void closeSessionFactory() {
		sessionFactory.close();
	}

	public static Session openSession() {
		return sessionFactory.openSession();
	}


	public static Object getSingleResult(String sql) {
		Session session = openSession();
		Object object = session.createQuery(sql).getSingleResult();
		session.close();
		return object;
	}

	public static Object getListResult(String sql) {
		Session session = openSession();
		Object object = session.createQuery(sql).list();
		session.close();
		return object;
	}

	public static Object getListResult(String sql, int limit) {
		Session session = openSession();
		session.beginTransaction();
		Object object = session.createQuery(sql).setMaxResults(limit).list();
		session.close();
		return object;
	}

	public static boolean singleResultExists(String query) {
		Session session = openSession();
		session.beginTransaction();
		boolean exists = session.createQuery(query).uniqueResult() != null;
		session.close();
		return exists;
	}

	public static void executeUpdate(String sql) {
		Session session = null;
		try {
			session = openSession();
			session.beginTransaction();
			session.createQuery(sql).executeUpdate();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			logger.error("Error during execution of update query. (" + e + ")");
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	public static void save(Object object) {
		Session session = null;
		try {
			session = openSession();
			session.beginTransaction();
			session.save(object);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			logger.error("Error during saving of object. (" + e + ")");
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

}
