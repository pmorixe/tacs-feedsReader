package ar.edu.utn.frba.tacs.grupo1.connection;

import java.util.List;
import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;
import org.hibernate.Session;
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
	
	@SuppressWarnings("unchecked")
    @Test
	public void testForSelect(){
	  Session session = HibernateUtil.getSessionFactory().openSession();
	  session.beginTransaction();
	  List<Subscription> result = (List<Subscription>) session.createQuery("from Subscription").list();
	  session.getTransaction().commit();
	  CollectionUtils.forAllDo(result, new Closure() {
        
        public void execute(Object arg0) {
          System.out.println(((Subscription)arg0).getUrl());
        }
      });
	}
}
