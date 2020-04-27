package com.ems.blog.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.ems.blog.dao.BlogPostDAO;
import com.ems.blog.exception.BlogException;
import com.ems.blog.web.mvc.json.UpdateMapper;
import com.ems.blog.web.mvc.json.UpdateOperationType;
import com.ems.blog.web.mvc.json.UpdateRequest;

public class MainTest {

	public static void main(String[] args) throws BlogException {
		ApplicationContext ctx = new AnnotationConfigApplicationContext("com.ems.blog");
		MongoTemplate opr = ctx.getBean(MongoTemplate.class);
		BlogPostDAO blogPostDAO = ctx.getBean(BlogPostDAO.class);
		System.out.println(blogPostDAO.getById("55ddf61c4d8b6037c0f90dfc"));
		blogPostDAO.deleteById("55ddf61c4d8b6037c0f90dfc");
	/*	System.out.println(blogPostDAO.getAll());
		UpdateRequest updateRequest = new UpdateRequest();
		updateRequest.setId("55e3ef11770712bb60f07ce8");
		Set<UpdateMapper> mappings= new HashSet<UpdateMapper>();
		UpdateMapper mapper = new UpdateMapper();
		mapper.setKey("rating");
		//List a = new ArrayList();
		//a.add("Updated Tag 1");
		mapper.setValue("1");
		mapper.setType(UpdateOperationType.inc);
		UpdateMapper mapper1 = new UpdateMapper();
		mapper1.setKey("authorName");
		mapper1.setValue("Mani rikhi updated");
		mapper1.setType(UpdateOperationType.set);
		mappings.add(mapper1);
		mappings.add(mapper);
		updateRequest.setMappings(mappings);
		System.out.println(blogPostDAO.updateDocument(updateRequest));*/
	}

}
