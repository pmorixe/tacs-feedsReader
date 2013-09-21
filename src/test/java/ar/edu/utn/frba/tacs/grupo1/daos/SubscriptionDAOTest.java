package ar.edu.utn.frba.tacs.grupo1.daos;

import org.junit.Test;

import ar.edu.utn.frba.tacs.grupo1.daos.DAO;
import ar.edu.utn.frba.tacs.grupo1.domain.Subscription;

public class SubscriptionDAOTest {
	
	@Test
	public void testSaveSubscription() throws Exception {
		Subscription subscription = new Subscription("www.algo.com");
		DAO.save(subscription);
		
	}
	@Test
	public void testGetSubscriptionsList() throws Exception {
		DAO.list("Subscription");
	}
	
}
