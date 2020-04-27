package com.ems.blog.service;

import java.util.List;

import com.ems.blog.exception.BlogException;
import com.ems.blog.model.Post;


public interface PostService {
	public boolean savePost(final Post post) throws BlogException;
	public List<Post> getPosts() throws BlogException;
	public Post getPostById(final String id) throws BlogException;
	public boolean updatePost(final Post post) throws BlogException;
	public boolean deletePost(final String id) throws BlogException;
}
