package ar.edu.utn.frba.tacs.grupo1.daos;

import ar.edu.utn.frba.tacs.grupo1.domain.Feed;
import ar.edu.utn.frba.tacs.grupo1.domain.Subscription;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;

public class SubscriptionDAOTest {

	private Subscription subscription;
	private Feed feed;

	@Before
	public void setUpSubscription() {
		this.subscription = new Subscription("www.foo.com");
		this.feed = new Feed("feed title", "feed link", "feed description");
	}

	@Test
	public void testSaveSubscription() {
		this.subscription.addFeed(this.feed);
		int createdId = DAO.save(this.subscription);
		assert (createdId != 0);
	}

	@Test
	public void testGetSubscriptionsById() {
		int createdId = DAO.save(this.subscription);
		subscription = (Subscription) DAO.getById(Subscription.class, createdId);
		assertNotNull(subscription);
		assert (subscription.getId() == createdId);
	}

	@Test
	public void testGetSubscriptionsList() {
		DAO.save(this.subscription);
		assertFalse(DAO.list(Subscription.class).isEmpty());
	}

	/* Me rindo, tengo que estudiar bien como es el tema de hibernate -hpieroni
	@Test
	public void testGetFeedsFromSubscription() throws Exception {
		this.subscription.addFeed(this.feed);
		int createdId = DAO.save(this.subscription);
		//DAO.save(this.feed);
		Subscription persistedSubscription = (Subscription) DAO.getById(Subscription.class, createdId);
		assertFalse(persistedSubscription.getFeeds().isEmpty());
		assertTrue(persistedSubscription.getFeeds().contains(this.feed));
	}
    */

	@After
	public void tearDownSubscription() {
		DAO.delete(this.subscription);
	}

}