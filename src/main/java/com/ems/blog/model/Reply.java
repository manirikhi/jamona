package com.ems.blog.model;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class Reply {
	private Integer replyId;
	@NotEmpty(message="Please provide your Name.")
    private String name;
    @NotEmpty(message="Comment should not be blank.")
    private String content;
    @NotEmpty(message="Please provide your valid Email.")
    private String email;
    private int likes;
    private int dislikes;
    private Date replyDate;
	/**
	 * @return the replyId
	 */
	public Integer getReplyId() {
		return replyId;
	}


	/**
	 * @param replyId the replyId to set
	 */
	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the likes
	 */
	public int getLikes() {
		return likes;
	}
	/**
	 * @param likes the likes to set
	 */
	public void setLikes(int likes) {
		this.likes = likes;
	}
	/**
	 * @return the dislikes
	 */
	public int getDislikes() {
		return dislikes;
	}
	/**
	 * @param dislikes the dislikes to set
	 */
	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}
	
	/**
	 * @return the replyDate
	 */
	public Date getReplyDate() {
		return replyDate;
	}


	/**
	 * @param replyDate the replyDate to set
	 */
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Reply [replyId=" + replyId + ", name=" + name
				+ ", content=" + content + ", email=" + email + ", likes="
				+ likes + ", dislikes=" + dislikes + "]";
	}
    
}
