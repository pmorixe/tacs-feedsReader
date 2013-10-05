package ar.edu.utn.frba.tacs.grupo1.updater;

import java.util.List;

import ar.edu.utn.frba.tacs.grupo1.daos.DAO;
import ar.edu.utn.frba.tacs.grupo1.domain.Subscription;
import ar.edu.utn.frba.tacs.grupo1.updaterServices.SubscriptionUpdaterService;

public class SubscriptionUpdaterTest {

  public void testSubscriptionUpdaterService() {
    List<?> list = DAO.list(Subscription.class);
    Subscription realSubscription = (Subscription) list.get(0);
    SubscriptionUpdaterService.update(realSubscription);

  }

}
