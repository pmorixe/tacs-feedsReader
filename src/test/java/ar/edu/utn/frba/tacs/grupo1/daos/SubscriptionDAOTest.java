package ar.edu.utn.frba.tacs.grupo1.daos;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;

import java.util.List;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;
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
    this.subscription = new Subscription("http://clarin.feedsportal.com/c/33088/f/577682/index.rss");
    this.entry = new Entry("Entry title", "Descripcion", "Entry Link", "Juan Carlos", "Sarlanga");
    this.feed = new Feed("feed title", "feed link", "feed summary", "spanish", "cprght", "a pubdate");
  }

  @Test
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
    feed.getEntries().add(entry);
    subscription.getFeeds().add(feed);
    subscription.getFeeds().add(feed);
    subscription.getFeeds().add(feed);
    DAO.save(this.subscription);
    List<Subscription> list = (List<Subscription>) DAO.list(Subscription.class);
    CollectionUtils.forAllDo(list, new Closure() {

      public void execute(Object arg0) {
        Subscription subs = (Subscription) arg0;
        System.out.println("\n" + subs.getFeeds().size() + ":" + subs.getUrl() + "\n");

      }
    });
    assertFalse(list.isEmpty());
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