package com.ypeksen.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;

import com.ypeksen.mvc.model.Job;
import com.ypeksen.mvc.model.JobListing;
import com.ypeksen.mvc.service.HRService;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;


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
  
  @RequestMapping(value = "/getJobListing", method = RequestMethod.POST)
  public String getJobListing(Model model, Principal principal, @RequestParam("id") int id) {

  	List<Job> jobSet = hrService.getJobByJobListingId(Long.valueOf(id));
  	boolean hasJob = false;
  	if(jobSet != null ){
  		if(jobSet.size() != 0){
    		hasJob = true;
  		}
  	}
    model.addAttribute("jobSet", jobSet);
    model.addAttribute("hasJob", hasJob);
    model.addAttribute("jobListingId",id);
       
    return "jobListingPage";
  }
  
  @RequestMapping(value = "/createJobPost", method = RequestMethod.POST)
  @ResponseBody
  public String createJobPost(Model model, Principal principal, @RequestParam("title") String title, @RequestParam("description") String description, @RequestParam("numOfPerson") int numOfPerson, @RequestParam("lastDate") String lastDate, @RequestParam("id") int id) {

		System.out.println("Hello create Job Post");
  	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
  	Date dateObj = null;  	
    String result = "{\"status\":1}";
		try {
			dateObj = format.parse(lastDate);
		} catch (ParseException e) {
			result = "{\"status\":0}";
			return result;
		}
		
		hrService.createJobPost(id, title, description, numOfPerson, dateObj);
          
    return result;
  }
}
