package ar.edu.utn.frba.tacs.grupo1.daos;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.springframework.beans.factory.ListableBeanFactory;

import ar.edu.utn.frba.tacs.grupo1.daos.SubscriptionDAO;
import ar.edu.utn.frba.tacs.grupo1.domain.Subscription;

public class SubscriptionDAOTest {
	
	@Test
	public void testRegistrarSubscripcion() throws Exception {
		Subscription subscripcion = new Subscription("www.algo.com");
		SubscriptionDAO.save(subscripcion);
	}
	
	@Test
	public void testListarSubscripciones() throws Exception{
		SubscriptionDAO subscriptionDAO = new SubscriptionDAO();
		List<Subscription> subscripciones = subscriptionDAO.listSubcripciones();
		CollectionUtils.forAllDo(subscripciones, new Closure() {
			
			public void execute(Object arg0) {
					Subscription subscription = (Subscription )arg0;
					System.out.println(subscription.getId()+" : "+ subscription.getSince());
			}
		});
	}
}
