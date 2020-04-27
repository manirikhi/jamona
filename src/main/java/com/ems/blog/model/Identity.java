package com.ems.blog.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Identity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 620684236294478793L;
	@Id
	private String id;
	private String secret;
	
	public Identity(String id, String secret) {
		super();
		this.id = id;
		this.secret = secret;
	}
	/**
	 * @return the id
	 */
	public synchronized String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public synchronized void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the secret
	 */
	public synchronized String getSecret() {
		return secret;
	}
	/**
	 * @param secret the secret to set
	 */
	public synchronized void setSecret(String secret) {
		this.secret = secret;
	}
	
}
