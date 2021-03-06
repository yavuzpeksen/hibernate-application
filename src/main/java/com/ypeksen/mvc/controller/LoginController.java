package com.ypeksen.mvc.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
  
  @RequestMapping(value = "/unauthorized", method = RequestMethod.GET)
  public String accessDenied(Model model, Principal principal) {

    if (principal != null) {
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String username = loginedUser.getUsername();
        model.addAttribute("username", username);
    }
    
    

    return "unauthorized";
  }
  
  @RequestMapping(value="/logout", method = RequestMethod.GET)
  public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
      if (auth != null){    
          new SecurityContextLogoutHandler().logout(request, response, auth);
      }
      return "logoutSuccessfulPage";
  }
  
  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public String getRegisterPage(Model model, HttpServletRequest request) {

  	model.addAttribute("userForm",  new com.ypeksen.mvc.model.User());
    return "register";
  }
  
}
