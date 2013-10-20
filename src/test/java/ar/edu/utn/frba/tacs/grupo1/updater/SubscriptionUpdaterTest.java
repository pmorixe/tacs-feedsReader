package ar.edu.utn.frba.tacs.grupo1.updater;

import java.util.List;

import ar.edu.utn.frba.tacs.grupo1.daos.DAO;
import ar.edu.utn.frba.tacs.grupo1.domain.Feed;
import ar.edu.utn.frba.tacs.grupo1.domain.Subscription;
import ar.edu.utn.frba.tacs.grupo1.updaterServices.SubscriptionUpdaterService;

public class SubscriptionUpdaterTest {

  public void testSubscriptionUpdaterService() {
    List<?> list = DAO.getInstance().list(Subscription.class);
    Subscription realSubscription = (Subscription) list.get(0);
    SubscriptionUpdaterService.getInstance().update(realSubscription);

  }

  // @Test
  public void testConcurrencySubscriptionUpdaterService() {
    SaveActionThread thread1 = new SaveActionThread("Soy el 1", 1);
    SaveActionThread thread2 = new SaveActionThread("Soy el 2", 2);
    SaveActionThread thread3 = new SaveActionThread("Soy el 3", 3);
    SaveActionThread thread4 = new SaveActionThread("Soy el 4", 4);
    SaveActionThread thread5 = new SaveActionThread("Soy el 5", 5);
    SaveActionThread thread6 = new SaveActionThread("Soy el 6", 6);
    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();
    thread5.start();
    thread6.start();
    List<?> list = DAO.getInstance().list(Subscription.class);

    Subscription realSubscription = (Subscription) list.get(0);

    Feed feed = realSubscription.getFeeds().get(0);

    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    System.out.println("------------------------------------------------");
    System.out.println(feed.getTitle());
    System.out.println("------------------------------------------------");

  }

  private class SaveActionThread extends Thread {

    private String name;

    private int i;

    public SaveActionThread(String string, int i) {
      this.name = string;
      // TODO Auto-generated constructor stub
      this.i = i;
    }

    @SuppressWarnings("static-access")
    public void run() {
      List<?> list = DAO.getInstance().list(Subscription.class);
      Subscription realSubscription = (Subscription) list.get(0);

      try {
        this.sleep(1000 * i);
        Feed feed = realSubscription.getFeeds().get(0);
        System.out.println("------------------------------------------------");
        System.out.println(name + feed.getTitle());
        System.out.println("------------------------------------------------");
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }
  }

}
