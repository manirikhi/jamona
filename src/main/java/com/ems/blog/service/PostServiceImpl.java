package com.ems.blog.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.ems.blog.dao.BlogPostDAO;
import com.ems.blog.exception.BlogException;
import com.ems.blog.model.Post;
import com.ems.blog.model.Rate;
import com.ems.blog.web.mvc.json.JsonRequest;

@Service("postService")
public class PostServiceImpl implements PostService {
	private static final Logger LOGGER = Logger
			.getLogger(PostServiceImpl.class);
	@Autowired
	@Qualifier("blogPostDAO")
	BlogPostDAO blogPostDAO;

	public boolean savePost(final Post post) throws BlogException {
		createPermalink(post);
		return blogPostDAO.create(post);
	}

	private void createPermalink(Post post) {
		String title = post.getTitle();
		LOGGER.info("Title of Post " + title);
		String permalink = title.replaceAll("[^a-zA-Z0-9\\s]", "").trim().replaceAll(" +", " ").replaceAll(" ", "-");
		LOGGER.info("The calculated Permalink of Post " + permalink);
		post.setPermalink(permalink);
	}

	public List<Post> getPosts() throws BlogException {
		return blogPostDAO.getAll();
	}

	public Post getPostById(final String id) throws BlogException {
		return blogPostDAO.getById(id);
	}

	public boolean updatePost(final Post post) throws BlogException {
		return blogPostDAO.update(post);
	}

	public boolean deletePost(final String id) throws BlogException {
		return blogPostDAO.deleteById(id);
	}

	public List<Post> getPostsByCategory(final String category)
			throws BlogException {
		return blogPostDAO.getPostsByCategory(category);
	}

	public void updateHitCount(String id) {
		blogPostDAO.updateHitCount(id);
	}

	public boolean updatePostRating(String postId, Rate rate) {
		return blogPostDAO.updatePostRating(postId, rate);
	}

	public Page<Post> getPostList(JsonRequest jsonRequest)
			throws BlogException {
		return blogPostDAO.getCollection(jsonRequest);
	}

	public Page<Post> getPostListBySearch(JsonRequest jsonRequest) {
		return blogPostDAO.getPostListBySearch(jsonRequest);
	}
}
