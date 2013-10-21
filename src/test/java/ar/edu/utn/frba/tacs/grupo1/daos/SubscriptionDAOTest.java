package ar.edu.utn.frba.tacs.grupo1.daos;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.utn.frba.tacs.grupo1.domain.Entry;
import ar.edu.utn.frba.tacs.grupo1.domain.Feed;
import ar.edu.utn.frba.tacs.grupo1.domain.Subscription;
import ar.edu.utn.frba.tacs.grupo1.domain.builders.EntryBuilder;
import ar.edu.utn.frba.tacs.grupo1.domain.builders.FeedBuilder;
import ar.edu.utn.frba.tacs.grupo1.domain.builders.SubscriptionBuilder;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
  "classpath:/servlet-Test-context.xml"
})
public class SubscriptionDAOTest {

  private Subscription subscription;

  private Feed feed;

  private Entry entry;

  @Autowired
  private DAO DAO;

  @Before
  public void setUpSubscription() {
    this.subscription = new Subscription("http://clarin.feedsportal.com/c/33088/f/577682/index.rss");
    this.entry = new Entry("Entry title", "Descripcion", "Entry Link", "Juan Carlos", "Sarlanga");
    this.feed = new Feed("feed title", "feed link", "feed summary", "spanish", "cprght", "a pubdate");
  }

  @Test
  public void testSaveSubscriptionAndGetFeeds() {
    feed.getEntries().add(entry);
    subscription.getFeeds().add(feed);
    int createdId = DAO.save(this.subscription);
    assert (createdId != 0);

    subscription = (Subscription) DAO.getById(Subscription.class, createdId);
    assertNotNull(subscription);
    assert (subscription.getId() == createdId);

    assert (subscription.getFeeds().size() > 0);

    assert (subscription.getAllEntries().size() > 0);
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

  public void simplePersistenTest() {
    Subscription subscription = new SubscriptionBuilder().withUrl("www.pepito.com").build();

    FeedBuilder feedBuilder = new FeedBuilder();
    Feed feed1 = feedBuilder.withTitle("Titulo 1").build();
    Feed feed2 = feedBuilder.withTitle("Titulo 2").build();

    EntryBuilder entryBuilder = new EntryBuilder();
    Entry entry1 = entryBuilder.withTitle("Titulo A").build();
    Entry entry2 = entryBuilder.withTitle("Titulo B").build();

    feed1.getEntries().add(entry1);
    feed1.getEntries().add(entry2);
    feed2.getEntries().add(entry1);
    feed2.getEntries().add(entry2);
    subscription.getFeeds().add(feed1);
    subscription.getFeeds().add(feed2);

    DAO.getInstance().save(subscription);

  }
}