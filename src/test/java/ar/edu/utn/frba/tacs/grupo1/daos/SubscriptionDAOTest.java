package ar.edu.utn.frba.tacs.grupo1.daos;

import org.junit.Test;

import ar.edu.utn.frba.tacs.grupo1.daos.DAO;
import ar.edu.utn.frba.tacs.grupo1.domain.Feed;
import ar.edu.utn.frba.tacs.grupo1.domain.Subscription;

public class SubscriptionDAOTest {
	
	
	public void testSaveSubscription() throws Exception {
		Subscription subscription = new Subscription("www.algo.com");
		Feed feed = new Feed();
		feed.setDescription("descripcion del feed");
		feed.setLink("link del feed");
		feed.setTitle("title del feed");
		subscription.addToFeeds(feed);
		int idCreated = DAO.save(subscription);
		assert(idCreated != 0);
	}
	@Test
	public void testGetSubscriptionsList() throws Exception {
		DAO.list(Subscription.class);
	}
	@Test
	public void testGetSubscriptionsById() throws Exception {
		Subscription subscription = new Subscription("www.algo.com");
		Feed feed = new Feed();
		feed.setDescription("descripcion del feed");
		feed.setLink("linkdel feed");
		feed.setTitle("title del feed");
		subscription.addToFeeds(feed);
		int idTest = DAO.save(subscription);
		assert(idTest != 0);
		subscription = null;
		subscription = (Subscription) DAO.getById(Subscription.class, idTest);
		assert(subscription != null);
		assert(subscription.getId() == idTest);
	}
	
}
