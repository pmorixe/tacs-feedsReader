package ar.edu.utn.frba.tacs.grupo1.daos;

import ar.edu.utn.frba.tacs.grupo1.domain.Domain;
import ar.edu.utn.frba.tacs.grupo1.hibernate.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.io.Console;
import java.lang.reflect.Method;
import java.util.List;

public class DAO {

	protected static Session getCurrentSession() {
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}

	/**
	 * @param domainObject
	 * @throws HibernateException
	 */
	public static int save(Domain domainObject) throws HibernateException {
		Session session = getCurrentSession();
		session.beginTransaction();
		session.save(domainObject);
		session.getTransaction().commit();
		return domainObject.getId();
	}

	/**
	 * @param domainObject
	 * @throws HibernateException
	 */
	public static void delete(Domain domainObject) throws HibernateException {
		Session session = getCurrentSession();
		session.beginTransaction();
		session.delete(domainObject);
		session.getTransaction().commit();
	}

	public static List<?> list(@SuppressWarnings("rawtypes") Class domainClass) {
		String className = domainClass.getName();
		Session session = getCurrentSession();
		session.getTransaction().begin();
		List<?> result = (List<?>) session.createQuery("from " + className).list();
		session.getTransaction().commit();
		return result;
	}

	public static Object getById(@SuppressWarnings("rawtypes") Class domainClass, int id) {
		String className = domainClass.getName();
		Session session = getCurrentSession();
		session.getTransaction().begin();
		List<?> allResults = session.createQuery("from " + className + " where id=" + String.valueOf(id)).list();
		session.getTransaction().commit();
		if (allResults.size() > 0)
			return allResults.get(0);
		return null;
	}
	public static List<?> getByFilter(@SuppressWarnings("rawtypes") Class domainClass, Method method, int valueRequired) {
      String className = domainClass.getSimpleName();
      String field = method.getName().replaceFirst("get", "").toLowerCase();
      Session session = getCurrentSession();
      session.getTransaction().begin();
      List<?> allResults = session.createQuery("from " + className + " where " + field + "=" + 
            String.valueOf(valueRequired)).list();
      session.getTransaction().commit();
      if (allResults.size() > 0)
          return allResults;
      return null;
  }

}
