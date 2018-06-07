package com.ypeksen.mvc.dao;

import com.ypeksen.mvc.model.User;

public interface UserDao {

	User findAuthenticatedUserByEmail(String email);
	
}
