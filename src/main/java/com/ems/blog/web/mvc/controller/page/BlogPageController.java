package com.ems.blog.web.mvc.controller.page;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogPageController {
	private static final String EMAIL_KEY = "email";
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> model = new HashMap<String,Object>();
		Cookie[] cookies = request.getCookies();
		boolean loginFlag = false;
		if(cookies != null){
		for (Cookie cookie : cookies) {
			if(EMAIL_KEY.equals(cookie.getName()) && request.getSession(false).getAttribute(EMAIL_KEY).equals(cookie.getValue())){
				loginFlag = true;
				break;
			}
		}
		}
		model.put("loginFlag", loginFlag);
		return new ModelAndView("index", model);
	}
	
	@RequestMapping(value={"/login"}, method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("message",
				"User loggged out successfully.");
		return "redirect:/login";
	}
}
