package com.cloudbees.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cloudbees.models.Subscripcion;

@Controller
public class SubscripcionController {

	//
	@RequestMapping("/subscripciones")
	public ModelAndView showSubscripciones() {
		return new ModelAndView("subscripcion", "command", new Subscripcion());
	}

	@RequestMapping(params = "/hi")
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Subs del día(?)");
		return "hello";
	}
}
