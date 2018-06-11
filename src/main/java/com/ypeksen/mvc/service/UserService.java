package com.ypeksen.mvc.service;

import java.util.List;

import com.ypeksen.mvc.model.Job;
import com.ypeksen.mvc.model.User;


public interface UserService {

	public List<Job> getAllJobs();

	public User getUserByEmail(String email);
		
}
