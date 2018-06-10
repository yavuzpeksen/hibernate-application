package com.ypeksen.mvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ypeksen.mvc.model.Job;

@Repository
public class JobDaoImpl implements JobDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<Job> findAll() {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("select j from Job j");
		List<Job> jobList = query.list();
		return jobList;
	}

	
}