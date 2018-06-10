package com.ypeksen.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;

import com.ypeksen.mvc.model.JobListing;
import com.ypeksen.mvc.service.HRService;

import java.security.Principal;


@Controller
@RequestMapping(value="/admin")
public class HRController {
	
  @Autowired
  private HRService hrService;
  
  @RequestMapping(value = "/homepage", method = RequestMethod.GET)
  public String homePage(Model model, Principal principal) {
       
      User loginedUser = (User) ((Authentication) principal).getPrincipal();
      String name = loginedUser.getUsername();
      boolean isAdmin = loginedUser.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
      Long jobListingId = -1L;
      if(isAdmin){
      	JobListing jl = hrService.getJobListingByEmail(loginedUser.getUsername());
      	if(jl != null){
      		jobListingId = jl.getId();
      	}
      }
      model.addAttribute("username",name);
      model.addAttribute("isAdmin",isAdmin);
      model.addAttribute("jobListingId",jobListingId);
      return "homepage";
  }
}
