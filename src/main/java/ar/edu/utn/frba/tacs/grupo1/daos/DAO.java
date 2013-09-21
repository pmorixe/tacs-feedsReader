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
	
	public static List<?> list(Object instancia){
	  String className = instancia.getClass().getName();
	  Session session = HibernateUtil.getSessionFactory().getCurrentSession();
      session.beginTransaction();      
      @SuppressWarnings("unchecked")
	List<Object> result = (List<Object>) session.createQuery("from "+ className).list();
      session.getTransaction().commit();
      
      return result;
	}

}
