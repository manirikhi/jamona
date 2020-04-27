package com.ems.blog.utils;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ems.blog.dao.AuditLogDAO;

@Aspect
public class LoggingAspect {
	private static final Logger LOGGER = Logger.getLogger(LoggingAspect.class);
	
	private AuditLogDAO auditLogDAO;
	
	/**
	 * @return the auditLogDAO
	 */
	public AuditLogDAO getAuditLogDAO() {
		return auditLogDAO;
	}

	/**
	 * @param auditLogDAO the auditLogDAO to set
	 */
	@Autowired
	@Qualifier("auditLogDAO")
	public void setAuditLogDAO(AuditLogDAO auditLogDAO) {
		this.auditLogDAO = auditLogDAO;
	}

	@After("execution(* com.ems.blog.service.PostServiceImpl.getPostList(..))")
	public void generalLogging(JoinPoint joinPoint){
		LOGGER.info("Before executing create "+Arrays.toString(joinPoint.getArgs()));
		LOGGER.info("In after advice");
		System.out.println("In after advice");
		//auditLogDAO.create()
	}
}
