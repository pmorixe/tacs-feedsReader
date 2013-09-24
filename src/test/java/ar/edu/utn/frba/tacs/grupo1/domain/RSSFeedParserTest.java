package ar.edu.utn.frba.tacs.grupo1.domain;
import static org.junit.Assert.*;
import org.junit.Test;
import ar.edu.utn.frba.tacs.grupo1.domain.Feed;
import ar.edu.utn.frba.tacs.grupo1.parser.RSSFeedParser;

public class RSSFeedParserTest {

  @Test
  public void testRSSFeed() {
    RSSFeedParser parser = new RSSFeedParser("http://clarin.feedsportal.com/c/33088/f/577682/index.rss");
    Feed feed = parser.readFeed();
    System.out.println(feed);
    System.out.println(feed.getEntries().get(1));
  }

}
