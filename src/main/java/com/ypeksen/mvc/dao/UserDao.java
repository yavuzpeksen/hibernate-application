package com.ypeksen.mvc.dao;

import org.springframework.stereotype.Repository;

import com.ypeksen.mvc.model.User;

public interface UserDao {

	User findAuthenticatedUserByEmail(String email);
	
}
