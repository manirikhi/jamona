package com.ems.blog.model;

import java.util.Date;

public class Session {
	private String sessionId;
	private String userId;
	private String JSESSIONID;
	private String ipAddress;
	private String userAgent;
	private Date startAt;
	private Date expireAt;
	private SessionStatus sessionStatus;
	/**
	 * @return the sessionId
	 */
	public synchronized String getSessionId() {
		return sessionId;
	}
	/**
	 * @param sessionId the sessionId to set
	 */
	public synchronized void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	/**
	 * @return the userId
	 */
	public synchronized String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public synchronized void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the jSESSIONID
	 */
	public synchronized String getJSESSIONID() {
		return JSESSIONID;
	}
	/**
	 * @param jSESSIONID the jSESSIONID to set
	 */
	public synchronized void setJSESSIONID(String jSESSIONID) {
		JSESSIONID = jSESSIONID;
	}
	/**
	 * @return the ipAddress
	 */
	public synchronized String getIpAddress() {
		return ipAddress;
	}
	/**
	 * @param ipAddress the ipAddress to set
	 */
	public synchronized void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	/**
	 * @return the userAgent
	 */
	public synchronized String getUserAgent() {
		return userAgent;
	}
	/**
	 * @param userAgent the userAgent to set
	 */
	public synchronized void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	/**
	 * @return the startAt
	 */
	public synchronized Date getStartAt() {
		return startAt;
	}
	/**
	 * @param startAt the startAt to set
	 */
	public synchronized void setStartAt(Date startAt) {
		this.startAt = startAt;
	}
	/**
	 * @return the expireAt
	 */
	public synchronized Date getExpireAt() {
		return expireAt;
	}
	/**
	 * @param expireAt the expireAt to set
	 */
	public synchronized void setExpireAt(Date expireAt) {
		this.expireAt = expireAt;
	}
	/**
	 * @return the sessionStatus
	 */
	public synchronized SessionStatus getSessionStatus() {
		return sessionStatus;
	}
	/**
	 * @param sessionStatus the sessionStatus to set
	 */
	public synchronized void setSessionStatus(SessionStatus sessionStatus) {
		this.sessionStatus = sessionStatus;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Session [sessionId=" + sessionId + ", userId=" + userId
				+ ", JSESSIONID=" + JSESSIONID + ", ipAddress=" + ipAddress
				+ ", userAgent=" + userAgent + ", startAt=" + startAt
				+ ", expireAt=" + expireAt + ", sessionStatus=" + sessionStatus
				+ "]";
	}
	
}
