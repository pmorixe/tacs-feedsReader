package ar.edu.utn.frba.tacs.grupo1.controller;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.edu.utn.frba.tacs.grupo1.daos.DAO;
import ar.edu.utn.frba.tacs.grupo1.domain.Subscription;
import ar.edu.utn.frba.tacs.grupo1.domain.Entry;

@Controller
@RequestMapping(value="/subscription")
public class SubscriptionController {
	
  @RequestMapping(value="/add",method=RequestMethod.GET)
	public String getaddSubscription(Model model) {
		model.addAttribute("subscription", new Subscription());
		return "subscription/add";
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String postaddSubscription(@Valid Subscription subscription, BindingResult result) throws Exception {
		if (result.hasErrors()) {
			return "subscription/add";
		}
		DAO.save(subscription);
		return "redirect:/";
	}
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String getlistSubscription(Model model) throws Exception {
		model.addAttribute("subscriptions", DAO.list(Subscription.class));
		return "subscription/list";
	}
	@RequestMapping(value="/read",method=RequestMethod.GET)
    public String getreadSubscription(Model model) throws Exception {
	    @SuppressWarnings("unchecked")
        List<Subscription> subscriptions = (List<Subscription>) DAO.list(Subscription.class);
	    List<Entry> entries = new ArrayList<Entry>();
	    for (Subscription subscription : subscriptions) {
	      entries.addAll(subscription.getAllEntries());
        }
        model.addAttribute("entries", entries);
        return "subscription/read";
    }
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
    public String getupdateSubscription(Model model) throws Exception {
        @SuppressWarnings("unchecked")
        List<Subscription> subscriptions = (List<Subscription>) DAO.list(Subscription.class);
        List<Entry> entries = new ArrayList<Entry>();
        for (Subscription subscription : subscriptions) {
          subscription.update();
          entries.addAll(subscription.getAllEntries());
        }
        model.addAttribute("entries", entries);
        return "subscription/read";
    }
}
