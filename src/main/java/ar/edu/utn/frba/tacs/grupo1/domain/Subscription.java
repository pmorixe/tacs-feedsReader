package ar.edu.utn.frba.tacs.grupo1.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "subscription")
public class Subscription implements Domain, Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String url;

  private Date since;

  @OneToMany(mappedBy = "subscription", cascade = CascadeType.ALL)
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
      entries.addAll(feed.getEntries());
    }
    return entries;
  }

  public void setFeeds(List<Feed> feeds) {
    this.feeds = feeds;
  }

}
