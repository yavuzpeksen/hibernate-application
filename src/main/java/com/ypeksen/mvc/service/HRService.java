package com.ypeksen.mvc.service;

import com.ypeksen.mvc.model.JobListing;

public interface HRService extends UserService {

	public JobListing getJobListingByEmail(String email);
}
