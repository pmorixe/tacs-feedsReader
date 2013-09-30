package ar.edu.utn.frba.tacs.grupo1.domain;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ar.edu.utn.frba.tacs.grupo1.parser.FeedParser;
import ar.edu.utn.frba.tacs.grupo1.parser.feed4j.RSSFeedIOException;
import ar.edu.utn.frba.tacs.grupo1.parser.feed4j.RSSFeedXMLParseException;
import ar.edu.utn.frba.tacs.grupo1.parser.feed4j.UnsupportedRSSFeedException;
import ar.edu.utn.frba.tacs.grupo1.daos.DAO;
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

  public List<Entry> update(){
	try {
		
		FeedParser parser = new FeedParser(this.url);
	    Feed feed = parser.readFeed();
	    //DAO.save(feed);
	    return feed.getEntries(); 
	    
	} catch (MalformedURLException e){
		
	} catch (UnsupportedRSSFeedException f) {
		// TODO: handle exception
	} catch (RSSFeedIOException g){
		
	} catch (RSSFeedXMLParseException h) {
		// TODO: handle exception
	}
    return null;
  }

}
