package com.ypeksen.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/accesspoint")
public class LoginController {

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String loginGetPage(Model model, String error, String logout, HttpServletRequest request) {

  	//System.out.println("Login entered..");
  	
  	if (error != null)
  		model.addAttribute("error", "Login unsuccessful");

    return "login";
  }
}
