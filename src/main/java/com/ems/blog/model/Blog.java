package com.ems.blog.model;

import java.io.Serializable;
import org.springframework.data.annotation.Id;

public class Blog implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private Post post;
    private Category category;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the post
	 */
	public Post getPost() {
		return post;
	}
	/**
	 * @param post the post to set
	 */
	public void setPost(Post post) {
		this.post = post;
	}
	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

    
}
