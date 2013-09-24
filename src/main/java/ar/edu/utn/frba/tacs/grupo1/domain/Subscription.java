package ar.edu.utn.frba.tacs.grupo1.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ar.edu.utn.frba.tacs.grupo1.daos.DAO;
import ar.edu.utn.frba.tacs.grupo1.parser.RSSFeedParser;

public class Subscription implements Domain {

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

  public void setFeeds(List<Feed> feeds) {
    this.feeds = feeds;
  }

  public List<Entry> update() {
    RSSFeedParser parser = new RSSFeedParser(this.url);
    Feed feed = parser.readFeed();
    //DAO.save(feed);
    return feed.getEntries();
  }

}
