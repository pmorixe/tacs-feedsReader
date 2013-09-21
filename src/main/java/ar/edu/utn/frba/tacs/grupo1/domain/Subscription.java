package ar.edu.utn.frba.tacs.grupo1.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Subscription implements Domain {
  
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String url;
	
	private Date since = new Date();

	public Subscription() {
	}

	public Subscription(String url) {
		this.url = url;
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
	public Set<Feed> getFeeds() {
		return feeds;
	}

	public void setFeeds(Set<Feed> feeds) {
		this.feeds = feeds;
	}
	public void addToFeeds(Feed feed) {
		feed.setSubscription(this);
		this.feeds.add(feed);
	}
	private Set<Feed> feeds = new HashSet<Feed>(0);

}
