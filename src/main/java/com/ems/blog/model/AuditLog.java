package com.ems.blog.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "auditLogs")
public class AuditLog {
	@Id
	private String id;
	private Date date;
	private String ActionType;
	private String ActionDesc;
	private String userEmail;
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
	 * @return the date
	 */
	public synchronized Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public synchronized void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the actionType
	 */
	public synchronized String getActionType() {
		return ActionType;
	}
	/**
	 * @param actionType the actionType to set
	 */
	public synchronized void setActionType(String actionType) {
		ActionType = actionType;
	}
	/**
	 * @return the actionDesc
	 */
	public synchronized String getActionDesc() {
		return ActionDesc;
	}
	/**
	 * @param actionDesc the actionDesc to set
	 */
	public synchronized void setActionDesc(String actionDesc) {
		ActionDesc = actionDesc;
	}
	/**
	 * @return the userEmail
	 */
	public synchronized String getUserEmail() {
		return userEmail;
	}
	/**
	 * @param userEmail the userEmail to set
	 */
	public synchronized void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
}
