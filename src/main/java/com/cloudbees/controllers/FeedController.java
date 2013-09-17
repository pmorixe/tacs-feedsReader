package com.cloudbees.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cloudbees.models.Feed;

@Controller
public class FeedController {

	@RequestMapping("/feeds")
	public ModelAndView showFeeds() {
		return new ModelAndView("feed", "command", new Feed());

	}

}
