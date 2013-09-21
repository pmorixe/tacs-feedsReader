package ar.edu.utn.frba.tacs.grupo1.daos;

import org.hibernate.Session;

import ar.edu.utn.frba.tacs.grupo1.connection.HibernateUtil;
import ar.edu.utn.frba.tacs.grupo1.domain.Subscription;

public class DAO {

	/**
	 * @param objeto
	 * @throws Exception 
	 */
	public void save(Object objeto) throws Exception {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    session.beginTransaction();
	    session.save(objeto);
	    session.getTransaction().commit(); 
	}

}
