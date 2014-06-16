package com.epsi.tpecommerce.service;

import java.util.List;

import com.epsi.tpecommerce.dao.UserDao;
import com.epsi.tpecommerce.entity.User;

public class UserService {
	
	UserDao userDao;
	
	public UserService() {
		userDao = new UserDao();
	}
	
	public User userCanLogin(String loginIhm, String passwordIhm) {
		User user = userDao.findByLogin(loginIhm);
		if(user.getPassword().length() > 4)
			return user;
		return null;
	}

	public User find(int id) {
		return userDao.find(id);
	}
	
	public List<User> getTwelveLastUsers(){
		return userDao.getLastUsers(12);
	}

}
