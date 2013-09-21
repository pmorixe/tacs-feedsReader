package ar.edu.utn.frba.tacs.grupo1.daos;

import java.util.List;

import org.hibernate.Session;

import ar.edu.utn.frba.tacs.grupo1.connection.HibernateUtil;
import ar.edu.utn.frba.tacs.grupo1.domain.Subscription;

public class DAO {

	/**
	 * @param objeto
	 * @throws Exception 
	 */
	public static void save(Object objeto) throws Exception {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    session.beginTransaction();
	    session.save(objeto);
	    session.getTransaction().commit(); 
	}

	public static List<?> list(String className){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	      session.beginTransaction();
	      List<?> result = (List<?>) session.createQuery("from "+ className).list();
	      session.getTransaction().commit();
	      return result;
	}

}
