package com.ypeksen.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ypeksen.mvc.dao.JobDao;
import com.ypeksen.mvc.model.Job;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private JobDao jobDao;

	@Override
	public List<Job> getAllJobs() {
		List<Job> jobList = jobDao.findAll();
		return jobList;		
	}
	
}
