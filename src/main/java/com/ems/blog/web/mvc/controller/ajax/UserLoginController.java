package com.ems.blog.web.mvc.controller.ajax;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ems.blog.dao.IdentityDAO;
import com.ems.blog.exception.BlogException;
import com.ems.blog.model.Identity;
import com.ems.blog.model.User;
import com.ems.blog.service.UserServiceImpl;
import com.ems.blog.utils.HashGenerator;

@Controller
public class UserLoginController {

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	@Qualifier("identityDAO")
	private IdentityDAO identityDAO;
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String addUser(HttpServletRequest request,
			HttpServletResponse response) throws BlogException {
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		User userDetails = userService.validateUser(email);
		if(userDetails == null){
			User user = new User();
			user.setFirstName(request.getParameter("firstName"));
			user.setLastName(request.getParameter("lastName"));
			user.setEmail(email);
			user.setUserCreationDate(new Date());
			user.setActive(true);
			userService.addUser(user);
			identityDAO.create(new Identity(user.getId(),HashGenerator.getHash(pass)));
			request.getSession().setAttribute("message", "User registeration success!");
		}else{
			request.getSession().setAttribute("message", "User alredy exists,Please login!");
		}
		
		return "login";
	}

	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public String validateUser(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws BlogException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = userService.validateUser(email);
		if (user != null) {
			String secret = identityDAO.getById(user.getId()).getSecret();
			if(StringUtils.isNotBlank(secret) && secret.equals(HashGenerator.getHash(password))){
				storeCookies(user,response);
				session.setAttribute("userName", user.getFirstName()+" "+user.getLastName());
				session.setAttribute("email", user.getEmail());
				return "redirect:/";
			}else{
				session.setAttribute("message", "Wrong user email or password!");
				return "redirect:/login";
			}
			
		} else{
			session.setAttribute("message", "Wrong user email or password!");
			return "redirect:/login";
		}
	}

	/**
	 * Store user information in cookies
	 * 
	 * @param user
	 */
	private void storeCookies(User user, HttpServletResponse response) {

		Cookie emailCookie = new Cookie("email", user.getEmail());
		emailCookie.setMaxAge(3600);
		Cookie userNameCookie = new Cookie("userName", user.getFirstName()
				+ " " + user.getLastName());
		userNameCookie.setMaxAge(3600);
		DateFormat df = new SimpleDateFormat("EEE, MMM d, yyy");
		Cookie dateCookie = new Cookie("creationDate", df.format(user.getUserCreationDate()));
		dateCookie.setMaxAge(3600);
		Cookie userIdCookie = new Cookie("userId", user.getId());
		userIdCookie.setMaxAge(3600);
		response.addCookie(emailCookie);
		response.addCookie(userNameCookie);
		response.addCookie(dateCookie);
		response.addCookie(userIdCookie);
	}

}
