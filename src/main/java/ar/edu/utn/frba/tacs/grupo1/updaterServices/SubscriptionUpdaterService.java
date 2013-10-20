package ar.edu.utn.frba.tacs.grupo1.updaterServices;

import java.net.MalformedURLException;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.utn.frba.tacs.grupo1.daos.DAO;
import ar.edu.utn.frba.tacs.grupo1.domain.Feed;
import ar.edu.utn.frba.tacs.grupo1.domain.Subscription;
import ar.edu.utn.frba.tacs.grupo1.parser.FeedParser;
import ar.edu.utn.frba.tacs.grupo1.parser.feed4j.RSSFeedIOException;
import ar.edu.utn.frba.tacs.grupo1.parser.feed4j.RSSFeedXMLParseException;
import ar.edu.utn.frba.tacs.grupo1.parser.feed4j.UnsupportedRSSFeedException;
import ar.edu.utn.frba.tacs.grupo1.predicates.AlreadySubscribedPredicate;

@Service
public class SubscriptionUpdaterService {

  @Autowired
  private DAO DAO;

  @Autowired
  private FeedUpdaterService feedUpdaterService;

  private static SubscriptionUpdaterService instance = null;

  public static SubscriptionUpdaterService getInstance() {
    if (instance == null)
      return instance = new SubscriptionUpdaterService();
    return instance;
  }

  public void update(Subscription subscription) {
    try {
      int updates = 0;
      FeedParser parser = new FeedParser(subscription.getUrl());
      if (parser != null) {
        Feed newFeed = parser.readFeed();
        // Me fijo si existe en la subscripcion
        Feed feed = (Feed) CollectionUtils.find(subscription.getFeeds(), new AlreadySubscribedPredicate(
            newFeed));
        if (feed != null) {
          updates = feedUpdaterService.update(feed, newFeed.getEntries());
        } else {
          subscription.getFeeds().add(newFeed);
          updates++;
        }
        // Si hay actualizaciones grabo
        if (updates > 0)
          DAO.save(subscription);
      }
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
