package com.ems.blog.web.mvc.controller.ajax;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ems.blog.exception.BlogException;
import com.ems.blog.model.Attachment;
import com.ems.blog.service.AttachmentServiceImpl;
import com.ems.blog.web.mvc.json.JsonRequest;
import com.ems.blog.web.mvc.json.JsonRpc;

@Controller
public class AttachmentAjaxController {
	private static final Logger LOGGER = Logger.getLogger(AttachmentAjaxController.class);
	@Autowired
	@Qualifier("attachmentService")
	AttachmentServiceImpl attachmentService;
	
	@RequestMapping(value="ajax/saveAttachment", method = RequestMethod.POST)
	@ResponseBody
	public JsonRpc<Boolean> saveAttachment(@Valid @RequestBody Attachment Attachment,BindingResult result) throws BlogException {
		if(result.hasErrors()){
			throw new BlogException(result.getFieldError().getDefaultMessage());
		}
		return new JsonRpc<Boolean>(attachmentService.saveAttachment(Attachment));
	}

	@RequestMapping(value="ajax/Attachments", method = RequestMethod.POST)
	@ResponseBody
	public JsonRpc<Page<Attachment>> getAttachments(@RequestBody JsonRequest jsonRequest) throws BlogException {
		return new JsonRpc<Page<Attachment>>(attachmentService.getAttachmentList(jsonRequest));
	}

	@RequestMapping(value="ajax/deleteAttachment", method = RequestMethod.GET)
	@ResponseBody
	public JsonRpc<Boolean> deleteUser(@RequestParam String  AttachmentId) throws BlogException {
		return new JsonRpc<Boolean>(attachmentService.deleteAttachment(AttachmentId));
	}
	
	@RequestMapping(value="/Attachments/update", method = RequestMethod.PUT)
	@ResponseBody
	public JsonRpc<Boolean> updateUser(@Valid @RequestBody Attachment Attachment) throws BlogException {
		return new JsonRpc<Boolean>(attachmentService.updateAttachment(Attachment));
	}
	
	@RequestMapping(value="ajax/Attachment", method = RequestMethod.GET)
	@ResponseBody
	public JsonRpc<Attachment> getUserById(@RequestParam("AttachmentId") String  AttachmentId) throws BlogException {
	    return new JsonRpc<Attachment>(attachmentService.getAttachmentById(AttachmentId));
	}

}
