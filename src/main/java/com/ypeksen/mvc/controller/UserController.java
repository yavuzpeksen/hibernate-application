package com.ypeksen.mvc.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
  
  @RequestMapping(value = "/homepage", method = RequestMethod.GET)
  public String homePage(Model model, Principal principal) {
       
      User loginedUser = (User) ((Authentication) principal).getPrincipal();
      boolean isAdmin = loginedUser.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
      if(isAdmin){
      	return "redirect:/admin/homepage";
      }	
      /*
      	List<Job> jobList = userService.getAllJobs();
      	boolean hasJob = false;
      	if(jobList != null){
      		if(jobList.size() != 0){
        		hasJob = true;
      		}
      	}
      	model.addAttribute("jobList", jobList);
      	model.addAttribute("hasJob", hasJob);
      String name = loginedUser.getUsername();
      model.addAttribute("username",name);
      model.addAttribute("isAdmin",isAdmin);
      
      //model.addAttribute("jobListingId",jobListingId);*/
      return "homepage";
  }
}
