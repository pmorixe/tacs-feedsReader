package ar.edu.utn.frba.tacs.grupo1.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Subscription implements Domain {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String url;
	private Date since;
	private Set<Feed> feeds;

	public Subscription(String url) {
		this();
		this.url = url;
	}

	public Subscription() {
		this.since = new Date();
		this.feeds = new HashSet<Feed>(0);
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

	public void addFeed(Feed feed) {
		this.feeds.add(feed);
	}

}
