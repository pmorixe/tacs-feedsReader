package ar.edu.utn.frba.tacs.grupo1.controller;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ar.edu.utn.frba.tacs.grupo1.constant.FeedsReaderConstants;
import ar.edu.utn.frba.tacs.grupo1.daos.DAO;
import ar.edu.utn.frba.tacs.grupo1.domain.Subscription;

@Controller
@RequestMapping(value="/subscription")
public class SubscriptionController {
	
  @RequestMapping(value="/add",method=RequestMethod.GET)
	public String getaddSubscription(Model model) {
		model.addAttribute(new Subscription());
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
}
