package ar.edu.utn.frba.tacs.grupo1.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ar.edu.utn.frba.tacs.grupo1.daos.DAO;


public class SubscriptionTest {

  @SuppressWarnings("unchecked")
  @Test
  public void updatesBringsAtLeastOneEntry() {
    List<Subscription> subscriptions = (List<Subscription>) DAO.list(Subscription.class);
    List<Entry> entries = new ArrayList<Entry>();
    for (Subscription subscription : subscriptions) {
      entries.addAll(subscription.update());
    }
    assert(entries.size()>0);
  }

}
