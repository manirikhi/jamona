package com.ems.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoURI;

@Configuration
public class MongoConfiguration {

	public @Bean
	MongoDbFactory adminMongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(new MongoClient("127.0.0.1"), "emsblogs");
	}

	public @Bean
	MongoTemplate adminMongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate(adminMongoDbFactory());
//		Mongo mongo = new Mongo(new MongoURI("mongodb://592a63270c1e66234e000081-emspro.rhcloud.com:37201/"));
//		UserCredentials userCredentials = new UserCredentials("admin","RY6Ck2GDeP3h");
//		MongoTemplate mongoTemplate = new MongoTemplate(mongo, "blog", userCredentials);
		return mongoTemplate;
	}

}