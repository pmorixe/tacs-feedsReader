package ar.edu.utn.frba.tacs.grupo1.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.utn.frba.tacs.grupo1.daos.DAO;
import ar.edu.utn.frba.tacs.grupo1.domain.Entry;
import ar.edu.utn.frba.tacs.grupo1.domain.Subscription;
import ar.edu.utn.frba.tacs.grupo1.updaterServices.SubscriptionUpdaterService;

@Controller
@RequestMapping(value = "/subscription")
public class SubscriptionController {

  @RequestMapping(value = "/add", method = RequestMethod.GET)
  public String getaddSubscription(Model model) {
    model.addAttribute("subscription", new Subscription());
    return "subscription/add";
  }

  @RequestMapping(value = "/add", method = RequestMethod.POST)
  public String postaddSubscription(@Valid Subscription subscription, BindingResult result) throws Exception {
    if (result.hasErrors()) {
      return "subscription/add";
    }
    DAO.getInstance().save(subscription);
    return "redirect:/";
  }
  
  @RequestMapping(value = "/important", method = RequestMethod.GET)
  public String importantEntry(@RequestParam("id") Integer entryId) throws Exception {
    Entry entry = (Entry) DAO.getInstance().getById(Entry.class, entryId);
    entry.setImportant(!entry.getImportant()); //marca o desmarca como importante
    DAO.getInstance().save(entry);
    return "redirect:/subscription/read";
  }
  
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String getlistSubscription(Model model) throws Exception {
    List<?> list = DAO.getInstance().list(Subscription.class);
    model.addAttribute("subscriptions", list);
    return "subscription/list";
  }

  @RequestMapping(value = "/read", method = RequestMethod.GET)
  public String getreadSubscription(Model model) throws Exception {
    @SuppressWarnings("unchecked")
    List<Subscription> subscriptions = (List<Subscription>) DAO.getInstance().list(Subscription.class);
    List<Entry> entries = new ArrayList<Entry>();
    for (Subscription subscription : subscriptions) {
      entries.addAll(subscription.getAllEntries());
    }
    model.addAttribute("entries", entries);
    return "subscription/read";
  }

  @RequestMapping(value = "/update", method = RequestMethod.GET)
  public String getupdateSubscription(Model model) throws Exception {
    @SuppressWarnings("unchecked")
    List<Subscription> subscriptions = (List<Subscription>) DAO.getInstance().list(Subscription.class);
    List<Entry> entries = new ArrayList<Entry>();
    for (Subscription subscription : subscriptions) {
      SubscriptionUpdaterService.getInstance().update(subscription);
      entries.addAll(subscription.getAllEntries());
    }
    model.addAttribute("entries", entries);
    return "subscription/read";
  }
}
