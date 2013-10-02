package ar.edu.utn.frba.tacs.grupo1.RSSFeed;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import ar.edu.utn.frba.tacs.grupo1.rss.Feed;
import ar.edu.utn.frba.tacs.grupo1.rss.RSSFeedParser;


public class RSSFeed extends TestCase {

	@Test
	public void testRSSFeed() {
		RSSFeedParser parser = new RSSFeedParser("http://clarin.feedsportal.com/c/33088/f/577682/index.rss");
	    Feed feed = parser.readFeed();
	    System.out.println(feed);
	    System.out.println(feed.getEntries().get(1));
	}

}
