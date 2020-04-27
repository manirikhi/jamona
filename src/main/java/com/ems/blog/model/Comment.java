package com.ems.blog.model;
/**
 * @author mani
 *
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comments")
public class Comment {
    @Id
    private String id;
    private String postId;
    @NotEmpty(message="Please provide your Name.")
    private String name;
    @NotEmpty(message="Comment should not be blank.")
    private String content;
    @NotEmpty(message="Please provide your valid Email.")
    private String email;
    private int likes;
    private int dislikes;
    private int noOfReplies;
    private List<Reply> replies = new ArrayList<Reply>();
    private Date commentDate;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getContent() {
		return content;
	}
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
	public synchronized int getDislikes() {
		return dislikes;
	}
	/**
	 * @param dislikes the dislikes to set
	 */
	public synchronized void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}
	
	/**
	 * @return the noOfReplies
	 */
	public int getNoOfReplies() {
		return noOfReplies;
	}
	/**
	 * @param noOfReplies the noOfReplies to set
	 */
	public void setNoOfReplies(int noOfReplies) {
		this.noOfReplies = noOfReplies;
	}
	/**
	 * @return the replies
	 */
	public synchronized List<Reply> getReplies() {
		return replies;
	}
	/**
	 * @param replies the replies to set
	 */
	public synchronized void setReplies(List<Reply> replies) {
		this.replies = replies;
	}
	/**
	 * @return the commentDate
	 */
	public Date getCommentDate() {
		return commentDate;
	}
	/**
	 * @param commentDate the commentDate to set
	 */
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", postId=" + postId + ", name=" + name
				+ ", content=" + content + ", email=" + email + ", likes="
				+ likes + ", commentDate=" + commentDate + "]";
	}		
}
