package com.ems.blog.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ems.blog.exception.BlogException;
import com.ems.blog.model.Identity;

@Repository("identityDAO")
public class IdentityDAO extends AbstractDAO<Identity> {
	private static final Logger LOGGER = Logger.getLogger(IdentityDAO.class);

	public IdentityDAO() {
		super(Identity.class);
	}

	public boolean update(Identity t) throws BlogException {
		// TODO Auto-generated method stub
		return false;
	}

}
