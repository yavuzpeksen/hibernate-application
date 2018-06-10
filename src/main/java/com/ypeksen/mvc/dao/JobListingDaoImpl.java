package com.ypeksen.mvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ypeksen.mvc.model.Job;
import com.ypeksen.mvc.model.JobListing;

@Repository
public class JobListingDaoImpl implements JobListingDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public JobListing getJobListingByEmail(String email) {
		Query query = getSession().createQuery("select jl from JobListing jl INNER JOIN jl.user u ON u.id = jl.user AND u.email = :email");
		query.setParameter("email", email);
		List<JobListing> jobList = query.list();
		return jobList.get(0);
	}

}
