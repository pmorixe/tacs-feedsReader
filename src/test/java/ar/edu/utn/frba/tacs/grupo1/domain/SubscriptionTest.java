package ar.edu.utn.frba.tacs.grupo1.domain;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.utn.frba.tacs.grupo1.daos.DAO;
import ar.edu.utn.frba.tacs.grupo1.parser.feed4j.RSSFeedIOException;
import ar.edu.utn.frba.tacs.grupo1.parser.feed4j.RSSFeedXMLParseException;
import ar.edu.utn.frba.tacs.grupo1.parser.feed4j.UnsupportedRSSFeedException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
  "classpath:/servlet-Test-context.xml"
})
public class SubscriptionTest {

  @Autowired
  private DAO DAO;

  @Transactional
  @SuppressWarnings("unchecked")
  @Test
  public void getAllEntriesBringsAtLeastOneEntry() throws MalformedURLException, UnsupportedRSSFeedException,
      RSSFeedIOException, RSSFeedXMLParseException {
    List<Subscription> subscriptions = (List<Subscription>) DAO.list(Subscription.class);
    List<Entry> entries = new ArrayList<Entry>();
    for (Subscription subscription : subscriptions) {
      entries.addAll(subscription.getAllEntries());
    }
    assert (entries.size() > 0);
  }

}
