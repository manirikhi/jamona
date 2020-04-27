package com.ems.blog.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ems.blog.exception.BlogException;
import com.ems.blog.model.Attachment;

@Repository("attachmentDAO")
public class AttachmentDAO extends AbstractDAO<Attachment>{
	private static final Logger LOGGER = Logger.getLogger(AttachmentDAO.class);

	public AttachmentDAO() {
		super(Attachment.class);
	}

	public boolean update(Attachment t) throws BlogException {
		System.out.println("test");
		LOGGER.info("inside update method");
		return false;
	}

}
