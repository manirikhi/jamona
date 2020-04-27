package com.ems.blog.web.mvc.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class SessionValidationFilter implements Filter{
	private static final Logger LOGGER = Logger.getLogger(SessionValidationFilter.class);
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		LOGGER.info("Before session handling in filter");
		
		HttpSession session = ((HttpServletRequest) request).getSession(false);
		
		if(session != null && !session.isNew()) {
			LOGGER.info("Session and do filter");
			filterChain.doFilter(request, response);
		} else {
			HttpServletResponse httpResponse = (HttpServletResponse)response;
			httpResponse.sendRedirect("/login.jsp");
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
