package com.ypeksen.mvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ypeksen.mvc.model.Job;

public interface JobDao {

	List<Job> findAll();
}
