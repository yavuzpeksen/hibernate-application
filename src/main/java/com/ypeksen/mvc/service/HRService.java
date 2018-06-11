package com.ypeksen.mvc.service;

import java.util.Date;
import java.util.List;

import com.ypeksen.mvc.model.Job;
import com.ypeksen.mvc.model.JobListing;

public interface HRService extends UserService {

	public JobListing getJobListingByEmail(String email);
	
	public List<Job> getJobByJobListingId(Long id);
	
	public void createJobPost(int id, String title, String description, int numOfPerson, Date lastDate);

}
