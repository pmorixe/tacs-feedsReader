package ar.edu.utn.frba.tacs.grupo1.domain;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ar.edu.utn.frba.tacs.grupo1.daos.DAO;
import ar.edu.utn.frba.tacs.grupo1.parser.FeedParser;
import ar.edu.utn.frba.tacs.grupo1.parser.feed4j.RSSFeedIOException;
import ar.edu.utn.frba.tacs.grupo1.parser.feed4j.RSSFeedXMLParseException;
import ar.edu.utn.frba.tacs.grupo1.parser.feed4j.UnsupportedRSSFeedException;

public class Subscription implements Domain, Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String url;

  private Date since;

  private List<Feed> feeds = new ArrayList<Feed>();

  public Subscription(String url) {
    this.url = url;
  }

  public Subscription() {

  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getSince() {
    return since;
  }

  public void setSince(Date since) {
    this.since = since;
  }

  public List<Feed> getFeeds() {
    return feeds;
  }
  
  public List<Entry> getAllEntries() {
    List<Entry> entries = new ArrayList<Entry>();
    for (Feed feed : this.getFeeds()) {
      entries.addAll(
          feed.getEntries());
    }
    return entries;
  }

  public void setFeeds(List<Feed> feeds) {
    this.feeds = feeds;
  }

  public void update() {
    try {
      FeedParser parser = new FeedParser(this.url);
      Feed feed = parser.readFeed();
      this.feeds.add(feed);
      this.persist(feed);
    } catch (MalformedURLException e) {

    } catch (UnsupportedRSSFeedException f) {
      // TODO: handle exception
    } catch (RSSFeedIOException g) {

    } catch (RSSFeedXMLParseException h) {
      // TODO: handle exception
    }
  }

  private void persist(Feed feed) {
    //TODO validate it's not in the DB already
    /*Subscription subscription = (Subscription) DAO.getById(Subscription.class, feed.getSubscription().getId());
    subscription.getFeeds().*/
    DAO.save(feed);
    
  }

}
