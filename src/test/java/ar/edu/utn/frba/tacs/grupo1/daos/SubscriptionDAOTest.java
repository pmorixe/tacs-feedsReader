package ar.edu.utn.frba.tacs.grupo1.daos;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ar.edu.utn.frba.tacs.grupo1.domain.Entry;
import ar.edu.utn.frba.tacs.grupo1.domain.Feed;
import ar.edu.utn.frba.tacs.grupo1.domain.Subscription;

public class SubscriptionDAOTest {

  private Subscription subscription;

  private Feed feed;

  private Entry entry;

  @Before
  public void setUpSubscription() {
    this.subscription = new Subscription("www.SuperFoo.com");
    this.entry = new Entry("Entry title", "Descripcion", "Entry Link", "Juan Carlos", "Sarlanga");
    this.feed = new Feed("feed title", "feed link", "feed summary", "spanish", "cprght", "a pubdate");
  }

  public void testSaveSubscription() {
    feed.getEntries().add(entry);
    subscription.getFeeds().add(feed);
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

  /*
   * @Test public void testGetFeedsFromSubscription() throws Exception { this.subscription.addFeed(this.feed);
   * int createdId = DAO.save(this.subscription); //DAO.save(this.feed); Subscription persistedSubscription =
   * (Subscription) DAO.getById(Subscription.class, createdId);
   * assertFalse(persistedSubscription.getFeeds().isEmpty());
   * assertTrue(persistedSubscription.getFeeds().contains(this.feed)); }
   */

  @After
  public void tearDownSubscription() {
    DAO.delete(this.subscription);
  }

}