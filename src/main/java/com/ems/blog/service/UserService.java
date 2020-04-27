package com.ems.blog.service;

import java.util.List;

import com.ems.blog.exception.BlogException;
import com.ems.blog.model.User;

public interface UserService {
	public boolean addUser(User user) throws BlogException;
	public List<User> getUsers() throws BlogException;
	public User getUserById(String userId) throws BlogException;
	public boolean updateUser(User user) throws BlogException;
	public boolean deleteUser(String userId) throws BlogException;
}
