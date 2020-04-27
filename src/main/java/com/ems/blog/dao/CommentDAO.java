package com.ems.blog.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.ems.blog.exception.BlogException;
import com.ems.blog.model.Comment;

@Repository("commentDAO")
public class CommentDAO extends AbstractDAO<Comment>{
	private static final Logger LOGGER = Logger.getLogger(CommentDAO.class);
	public CommentDAO(){
		super(Comment.class);
	}

	public boolean update(Comment comment) throws BlogException{
	Query searchCommentQuery = new Query(Criteria.where("_id").is(comment.getId()));
		LOGGER.info("Before updating comment "+comment);
		Update update = new Update();
		update.set("content", comment.getContent());
		update.set("name", comment.getName());
		update.set("email",comment.getEmail());
		update.set("commentDate", comment.getCommentDate());
		
		mongoTemplate.updateFirst(searchCommentQuery, update, Comment.class);
		return true;
	}
	
	public List<Comment> getCommentByPostId(String postId){
		LOGGER.info("Fetching comments for post id := "+postId);
		List<Comment> list = new ArrayList<Comment>();
		if(postId == null)
			return list;
		Query query = new Query(new Criteria("postId").is(postId));
		list = mongoTemplate.find(query, Comment.class);
		LOGGER.info("The comment List "+list);
		return list;
	}
}
