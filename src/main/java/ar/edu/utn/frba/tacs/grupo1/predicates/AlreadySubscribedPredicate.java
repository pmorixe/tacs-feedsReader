package ar.edu.utn.frba.tacs.grupo1.predicates;

import org.apache.commons.collections.Predicate;

import ar.edu.utn.frba.tacs.grupo1.domain.Feed;

public class AlreadySubscribedPredicate implements Predicate {

  private String urlToStringNewFeed;

  private String pubDateNewFeed;

  public AlreadySubscribedPredicate(Feed feed) {
    this.urlToStringNewFeed = feed.getUrl().toString();
    // this.pubDateNewFeed = feed.getPubDate();
  }

  @Override
  public boolean evaluate(Object arg0) {
    String urlToStringFeed = ((Feed) arg0).getUrl().toString();
    String pubDateFeed = ((Feed) arg0).getPubDate();

    return urlToStringFeed.equals(urlToStringNewFeed);
  }

}
