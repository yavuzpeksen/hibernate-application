package com.ypeksen.mvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ypeksen.mvc.model.User;

@Repository
public class UserDaoImpl implements UserDao{	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public User findAuthenticatedUserByEmail(String email) {
		Query query = getSession().createQuery("select u from User u where u.email = :email and u.authenticated = 1");
		query.setParameter("email", email);
		List<User> userList = query.list();
		return userList.get(0);
	}

	@Override
	public User findByEmail(String email) {
		Query query = getSession().createQuery("select u from User u where u.email = :email");
		query.setParameter("email", email);
		List<User> userList = query.list();
		return userList.get(0);
	}

	@Override
	public void save(User user) {
		getSession().save(user);
	}

}
