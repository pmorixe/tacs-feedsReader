package ar.edu.utn.frba.tacs.grupo1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.edu.utn.frba.tacs.grupo1.daos.DAO;
import ar.edu.utn.frba.tacs.grupo1.domain.Feed;
import ar.edu.utn.frba.tacs.grupo1.domain.Subscription;

@Controller
@RequestMapping(value = "/feed")
public class FeedController {

  @SuppressWarnings("unchecked")
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String getlistSubscription(Model model) throws Exception {
    List<Subscription> subscriptions = (List<Subscription>) DAO.getInstance().list(Subscription.class);
    List<Feed> feeds = new ArrayList<Feed>();
    for (Subscription subscription : subscriptions) {
      feeds.addAll(subscription.getFeeds());
    }
    model.addAttribute("feeds", feeds);
    return "feed/list";
  }
}
