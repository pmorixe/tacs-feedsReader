package com.cloudbees.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloudbees.models.Account;

@Controller
@RequestMapping(value="/addFeed")
public class addFeedController {

	
	@RequestMapping(method=RequestMethod.GET)
	public String getaddFeed(Model model) {
		model.addAttribute(new Account());
		return "addFeed/addFeedForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String create(@Valid Account account, BindingResult result) {
		if (result.hasErrors()) {
			return "addFeed/addFeedForm";
		}
		return "redirect:/welcome";
	}

}
