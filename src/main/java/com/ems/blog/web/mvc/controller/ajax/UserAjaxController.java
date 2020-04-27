package com.ems.blog.web.mvc.controller.ajax;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ems.blog.exception.BlogException;
import com.ems.blog.model.User;
import com.ems.blog.service.UserServiceImpl;
import com.ems.blog.web.mvc.json.JsonRpc;


@Controller
public class UserAjaxController {
	@Autowired
	UserServiceImpl userService;

	@RequestMapping(value="/ajax/users", method = RequestMethod.GET)
	@ResponseBody
	public JsonRpc<List<User>> getUsers() throws BlogException {
		return new JsonRpc<List<User>>(userService.getUsers());
	}

	@RequestMapping(value="/ajax/user/{id}", method = RequestMethod.GET)
	@ResponseBody
	public JsonRpc<User> getUserById(@PathVariable String id) throws BlogException {
	    return new JsonRpc<User>(userService.getUserById(id));
		
	}

	@RequestMapping(value="/ajax/updateUser", method = RequestMethod.PUT)
	@ResponseBody
	public JsonRpc<Boolean> updateUser(@Valid @RequestBody User user) throws BlogException {
		return new JsonRpc<Boolean>(userService.updateUser(user));
	}

	@RequestMapping(value="/ajax/deleteUser", method = RequestMethod.GET)
	@ResponseBody
	public JsonRpc<Boolean> deleteUser(@RequestParam("userId") String userId) throws BlogException {
		return new JsonRpc<Boolean>(userService.deleteUser(userId));
	}
}