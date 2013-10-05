package ar.edu.utn.frba.tacs.grupo1.updaterServices;

import java.net.MalformedURLException;

import org.apache.commons.collections.CollectionUtils;

import ar.edu.utn.frba.tacs.grupo1.daos.DAO;
import ar.edu.utn.frba.tacs.grupo1.domain.Feed;
import ar.edu.utn.frba.tacs.grupo1.domain.Subscription;
import ar.edu.utn.frba.tacs.grupo1.parser.FeedParser;
import ar.edu.utn.frba.tacs.grupo1.parser.feed4j.RSSFeedIOException;
import ar.edu.utn.frba.tacs.grupo1.parser.feed4j.RSSFeedXMLParseException;
import ar.edu.utn.frba.tacs.grupo1.parser.feed4j.UnsupportedRSSFeedException;
import ar.edu.utn.frba.tacs.grupo1.predicates.AlreadySubscribedPredicate;

public class SubscriptionUpdaterService {

  public static void update(Subscription subscription) {
    try {
      FeedParser parser = new FeedParser(subscription.getUrl());
      Feed newFeed = parser.readFeed();
      // Me fijo si existe en la subscripcion
      Feed feed = (Feed) CollectionUtils.find(subscription.getFeeds(),
          new AlreadySubscribedPredicate(newFeed));
      if (feed != null) {
        FeedUpdaterService.update(feed, newFeed.getEntries());
      } else {
        subscription.getFeeds().add(newFeed);
      }
      DAO.save(subscription);
    } catch (MalformedURLException e) {
      // TODO: handle exception
    } catch (UnsupportedRSSFeedException f) {
      // TODO: handle exception
    } catch (RSSFeedIOException g) {

    } catch (RSSFeedXMLParseException h) {
      // TODO: handle exception
    }
  }
}
