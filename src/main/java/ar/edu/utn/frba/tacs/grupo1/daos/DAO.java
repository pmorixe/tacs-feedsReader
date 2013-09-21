package ar.edu.utn.frba.tacs.grupo1.daos;

import java.util.List;

import org.hibernate.Session;

import ar.edu.utn.frba.tacs.grupo1.hibernate.HibernateUtil;
import ar.edu.utn.frba.tacs.grupo1.domain.Domain;
import ar.edu.utn.frba.tacs.grupo1.domain.Subscription;

public class DAO {

	/**
	 * @param objeto
	 * @throws Exception 
	 */
	public static int save(Domain objeto) throws Exception {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    session.getTransaction().begin();
	    session.save(objeto);
	    session.getTransaction().commit(); 
	    return objeto.getId();
	}

	public static List<?> list(@SuppressWarnings("rawtypes") Class clase){
		String className = clase.getName();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	      session.getTransaction().begin();
	      List<?> result = (List<?>) session.createQuery("from "+ className).list();
	      session.getTransaction().commit();
	      return result;
	}
	
	public static Object getById(@SuppressWarnings("rawtypes") Class clase, int id){
		String className = clase.getName();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	      session.getTransaction().begin();
	      List<?> allResults = session.createQuery("from "+ className + " where id="+ String.valueOf(id)).list();
	      session.getTransaction().commit();
	      if (allResults.size() > 0)
	    	  return allResults.get(0);
	      return null;
	}

}
