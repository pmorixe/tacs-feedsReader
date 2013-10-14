package ar.edu.utn.frba.tacs.grupo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

  @RequestMapping(value = "/login-form", method = RequestMethod.GET)
  public ModelAndView loginForm() {
    return new ModelAndView("/account/login-form");
  }

  @RequestMapping(value = "/error-login", method = RequestMethod.GET)
  public ModelAndView invalidLogin() {
    ModelAndView modelAndView = new ModelAndView("login-form");
    modelAndView.addObject("error", true);
    return modelAndView;
  }

  @RequestMapping(value = "/success-login", method = RequestMethod.GET)
  public ModelAndView successLogin() {
    return new ModelAndView("/account/success-login");
  }

}
