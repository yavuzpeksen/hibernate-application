package com.ypeksen.mvc.dao;

import com.ypeksen.mvc.model.JobListing;

public interface JobListingDao {

	JobListing getJobListingByEmail(String email);
}
