package ar.edu.utn.frba.tacs.grupo1.domain;
import static org.junit.Assert.*;

import java.net.MalformedURLException;

import org.junit.Test;

import ar.edu.utn.frba.tacs.grupo1.domain.Feed;
import ar.edu.utn.frba.tacs.grupo1.parser.FeedParser;
import ar.edu.utn.frba.tacs.grupo1.parser.feed4j.RSSFeedIOException;
import ar.edu.utn.frba.tacs.grupo1.parser.feed4j.RSSFeedXMLParseException;
import ar.edu.utn.frba.tacs.grupo1.parser.feed4j.UnsupportedRSSFeedException;

public class RSSFeedParserTest {

  @Test
  public void testRSSFeed() throws MalformedURLException, UnsupportedRSSFeedException, RSSFeedIOException, RSSFeedXMLParseException {
    FeedParser parser = new FeedParser("http://clarin.feedsportal.com/c/33088/f/577682/index.rss");
    Feed feed = parser.readFeed();
    System.out.println(feed);
    System.out.println(feed.getEntries().get(1));
  }

}
