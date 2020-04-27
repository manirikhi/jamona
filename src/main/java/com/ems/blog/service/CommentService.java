package com.ems.blog.service;

import java.util.List;

import com.ems.blog.exception.BlogException;
import com.ems.blog.model.Comment;
import com.ems.blog.web.mvc.json.UpdateRequest;

public interface CommentService {
	public boolean addComment(Comment comment) throws BlogException;
	public List<Comment> getComments(String postId) throws BlogException;
	public Comment getCommentById(String commentId) throws BlogException;
	public boolean updateComment(Comment comment) throws BlogException;
	public boolean deleteComment(String commentId) throws BlogException;
	public boolean update(final UpdateRequest updateRequest) throws BlogException;
}
