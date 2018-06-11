package com.ypeksen.mvc.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ypeksen.mvc.dao.JobListingDao;
import com.ypeksen.mvc.model.Job;
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

	@Override
	public List<Job> getJobByJobListingId(Long id) {
		List<Job> jobSet = jobDao.getJobByJobListingId(id);
		return jobSet;
	}

	@Override
	public void createJobPost(int id, String title, String description, int numOfPerson, Date lastDate) {
		Job currentJob = new Job();
		JobListing currJobListing = new JobListing();
		
		currJobListing.setId(Long.valueOf(id));
		currentJob.setJobListing(currJobListing);
		currentJob.setTitle(title);
		currentJob.setDescription(description);
		currentJob.setHiringPersonNumber(numOfPerson);
		currentJob.setLastApplicationDate(lastDate);
		jobDao.save(currentJob);
		
	}
	
	@Override
	public void deleteJob(int postId) {
		
		jobDao.delete(Long.valueOf(postId));		
		
	}
}
