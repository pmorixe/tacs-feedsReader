package ar.edu.utn.frba.tacs.grupo1.connection;

import static org.junit.Assert.*;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.joda.time.DateTime;
import org.joda.time.chrono.BuddhistChronology;
import org.junit.Test;

import ar.edu.utn.frba.tacs.grupo1.connection.HibernateUtil;
import ar.edu.utn.frba.tacs.grupo1.domain.Subscription;

public class HibernateUtilTest {

	public void testSaveAction() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String unaUrl = "www.urlReloaded2.com";

        Subscription subscription = new Subscription();
		subscription.setUrl(unaUrl);
        session.save(subscription);

        session.getTransaction().commit();
	}
	
	public void testForSelect(){
	  Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	  Criteria createCriteria = session.createCriteria(Subscription.class).createCriteria("ID = 8");
	  
	}
	
	

}
