package com.ypeksen.mvc.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ypeksen.mvc.dao.JobDao;
import com.ypeksen.mvc.dao.UserDao;
import com.ypeksen.mvc.model.Job;
import com.ypeksen.mvc.model.Role;
import com.ypeksen.mvc.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	protected JobDao jobDao;
	
	@Autowired
	protected UserDao userDao;
	
  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public List<Job> getAllJobs() {
		List<Job> jobList = jobDao.findAll();
		return jobList;		
	}

	@Override
	public User getUserByEmail(String email) {
		return userDao.findByEmail(email);
	}
	
}
