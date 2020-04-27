package com.ems.blog.dao;

import org.springframework.stereotype.Repository;

import com.ems.blog.exception.BlogException;
import com.ems.blog.model.AuditLog;

@Repository("auditLogDAO")
public class AuditLogDAO{
	
/*	public AuditLogDAO() {
		setClazz(AuditLog.class);
	}*/

	public boolean update(AuditLog t) throws BlogException {
		// TODO Auto-generated method stub
		return false;
	}

}
