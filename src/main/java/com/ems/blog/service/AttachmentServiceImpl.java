package com.ems.blog.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.ems.blog.dao.AttachmentDAO;
import com.ems.blog.exception.BlogException;
import com.ems.blog.model.Attachment;
import com.ems.blog.web.mvc.json.JsonRequest;

@Service("attachmentService")
public class AttachmentServiceImpl implements AttachmentService {
	private static final Logger LOGGER = Logger
			.getLogger(AttachmentServiceImpl.class);
	@Autowired
	@Qualifier("attachmentDAO")
	AttachmentDAO attachmentDAO;

	public boolean saveAttachment(final Attachment Attachment) throws BlogException {
		return attachmentDAO.create(Attachment);
	}

	public List<Attachment> getAttachments() throws BlogException {
		return attachmentDAO.getAll();
	}

	public Attachment getAttachmentById(final String id) throws BlogException {
		return attachmentDAO.getById(id);
	}

	public boolean updateAttachment(final Attachment Attachment) throws BlogException {
		return attachmentDAO.update(Attachment);
	}

	public boolean deleteAttachment(final String id) throws BlogException {
		return attachmentDAO.deleteById(id);
	}

	public Page<Attachment> getAttachmentList(JsonRequest jsonRequest)
			throws BlogException {
		return attachmentDAO.getCollection(jsonRequest);
	}
}
