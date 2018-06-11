package com.ypeksen.mvc.dao;

import java.util.List;
import com.ypeksen.mvc.model.Job;
import com.ypeksen.mvc.model.JobListing;

public interface JobListingDao {

	JobListing getJobListingByEmail(String email);
}
