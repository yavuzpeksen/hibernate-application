package com.ypeksen.mvc.dao;

import com.ypeksen.mvc.model.User;

public interface UserDao {

	User findAuthenticatedUserByEmail(String email);
	
	User findByEmail(String email);

	void save(User user);
	
}
