package com.ems.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ems.blog.dao.CommentDAO;
import com.ems.blog.exception.BlogException;
import com.ems.blog.model.Comment;
import com.ems.blog.web.mvc.json.UpdateRequest;


@Service("commentService")
public class CommentServiceImpl implements CommentService{
	@Autowired
	@Qualifier("commentDAO")
	CommentDAO commentDAO;
	public boolean addComment(Comment comment) throws BlogException {
		return commentDAO.create(comment);
	}

	public List<Comment> getComments(String postId) throws BlogException {
		return commentDAO.getCommentByPostId(postId);
	}

	public Comment getCommentById(String id) throws BlogException {
		return commentDAO.getById(id);
	}

	public boolean updateComment(Comment Comment) throws BlogException {
		return commentDAO.update(Comment);
	}

	public boolean deleteComment(String CommentId) throws BlogException {
		return commentDAO.deleteById(CommentId);
	}

	public boolean update(UpdateRequest updateRequest) throws BlogException {
		return commentDAO.updateDocument(updateRequest);
	}
}
