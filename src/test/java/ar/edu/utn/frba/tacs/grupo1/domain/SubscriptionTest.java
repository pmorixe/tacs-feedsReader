package ar.edu.utn.frba.tacs.grupo1.domain;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ar.edu.utn.frba.tacs.grupo1.daos.DAO;
import ar.edu.utn.frba.tacs.grupo1.parser.feed4j.RSSFeedIOException;
import ar.edu.utn.frba.tacs.grupo1.parser.feed4j.RSSFeedXMLParseException;
import ar.edu.utn.frba.tacs.grupo1.parser.feed4j.UnsupportedRSSFeedException;

public class SubscriptionTest {

  @SuppressWarnings("unchecked")
  @Test
  public void getAllEntriesBringsAtLeastOneEntry() throws MalformedURLException, UnsupportedRSSFeedException,
      RSSFeedIOException, RSSFeedXMLParseException {
    List<Subscription> subscriptions = (List<Subscription>) DAO.getInstance().list(Subscription.class);
    List<Entry> entries = new ArrayList<Entry>();
    for (Subscription subscription : subscriptions) {
      entries.addAll(subscription.getAllEntries());
    }
    assert (entries.size() > 0);
  }

}
