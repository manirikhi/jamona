package com.ems.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ems.blog.dao.BlogUserDAO;
import com.ems.blog.exception.BlogException;
import com.ems.blog.model.User;


@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	@Qualifier("blogUserDAO")
	BlogUserDAO blogUserDAO;
	public boolean addUser(User user) throws BlogException {
		return blogUserDAO.create(user);
	}

	public List<User> getUsers() throws BlogException {
		return blogUserDAO.getAll();
	}

	public User getUserById(String id) throws BlogException {
		return blogUserDAO.getById(id);
	}

	public boolean updateUser(User user) throws BlogException {
		return blogUserDAO.update(user);
	}

	public boolean deleteUser(String userId) throws BlogException {
		return blogUserDAO.deleteById(userId);
	}
	
	public User validateUser(String email){
		return blogUserDAO.validateUser(email);
	}
}
