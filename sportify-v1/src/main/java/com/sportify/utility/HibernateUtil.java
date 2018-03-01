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
			logger.error("Initial SessionFactory creation failed. (" + e + ")");
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Object executeSingleResultQuery(String query) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			return session.createQuery(query).getSingleResult();
		} catch (HibernateException e) {
			logger.error("Error during execution of execute query. (" + e + ")");
			session.getTransaction().rollback();
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return null;
	}

	public static Object executeListQuery(String query) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			return session.createQuery(query).list();
		} catch (HibernateException e) {
			logger.error("Error during execution of execute query. (" + e + ")");
			session.getTransaction().rollback();
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return null;
	}

	public static Object executeListQuery(String query, int limit) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			return session.createQuery(query).setMaxResults(limit).list();
		} catch (HibernateException e) {
			logger.error("Error during execution of execute query. (" + e + ")");
			session.getTransaction().rollback();
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return null;
	}

	public static void executeUpdate(String query) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			session.createQuery(query).executeUpdate();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			logger.error("Error during execution of update query. (" + e + ")");
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	public static void saveObject(Object object) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
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
	
	public static void shutdown() {
		sessionFactory.getCurrentSession().close();
		sessionFactory.close();
	}

}
