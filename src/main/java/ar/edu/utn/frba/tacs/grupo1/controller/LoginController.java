package ar.edu.utn.frba.tacs.grupo1.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.utn.frba.tacs.grupo1.domain.MyUser;
import ar.edu.utn.frba.tacs.grupo1.updaterServices.MyUserUpdaterServices;

@Controller
public class LoginController {

  @Autowired
  private MyUserUpdaterServices myUserUpdaterServices;

  @RequestMapping(value = "/login-form", method = RequestMethod.GET)
  public ModelAndView loginForm() {
    return new ModelAndView("/account/login-form");
  }

  @RequestMapping(value = "/error-login", method = RequestMethod.GET)
  public ModelAndView invalidLogin() {
    ModelAndView modelAndView = new ModelAndView("/account/login-form");
    modelAndView.addObject("error", true);
    return modelAndView;
  }

  @RequestMapping(value = "/success-login", method = RequestMethod.GET)
  public ModelAndView successLogin() {
    return new ModelAndView("/account/success-login");
  }

  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public ModelAndView registerGet(Model model) {
    model.addAttribute("user", new MyUser());
    return new ModelAndView("account/register");
  }

  @Transactional
  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public ModelAndView registerPost(@Valid MyUser user, BindingResult result) {
    ModelAndView modelAndView = new ModelAndView("/account/login-form");
    String welcomeUsername = myUserUpdaterServices.validateAndRegisterUser(user);
    if (welcomeUsername == null) {
      modelAndView.addObject("error", true);
    }
    return modelAndView;
  }
}
