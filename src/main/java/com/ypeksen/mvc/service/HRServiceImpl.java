package com.ypeksen.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ypeksen.mvc.dao.JobListingDao;
import com.ypeksen.mvc.model.JobListing;

@Service("hrService")
@Transactional
public class HRServiceImpl extends UserServiceImpl implements HRService {
	
	@Autowired
	private JobListingDao jobListingDao;
	
	@Override
  public JobListing getJobListingByEmail(String email){
		JobListing jl = jobListingDao.getJobListingByEmail(email);
		return jl;
  }
}
