package com.ems.blog.service;

import java.util.List;

import com.ems.blog.exception.BlogException;
import com.ems.blog.model.Attachment;


public interface AttachmentService {
	public boolean saveAttachment(final Attachment Attachment) throws BlogException;
	public List<Attachment> getAttachments() throws BlogException;
	public Attachment getAttachmentById(final String id) throws BlogException;
	public boolean updateAttachment(final Attachment Attachment) throws BlogException;
	public boolean deleteAttachment(final String id) throws BlogException;
}
