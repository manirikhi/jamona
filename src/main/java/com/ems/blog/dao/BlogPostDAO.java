package com.ems.blog.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.ems.blog.exception.BlogException;
import com.ems.blog.model.Post;
import com.ems.blog.model.Rate;
import com.ems.blog.web.mvc.json.Filter;
import com.ems.blog.web.mvc.json.IncludeList;
import com.ems.blog.web.mvc.json.JsonRequest;
import com.ems.blog.web.mvc.json.Mapper;
@Repository("blogPostDAO")
public class BlogPostDAO extends AbstractDAO<Post>{
	private static final Logger LOGGER = Logger.getLogger(BlogPostDAO.class);
	public BlogPostDAO(){
		super(Post.class);
	}

	public boolean update(Post post) throws BlogException{
		Query searchPostQuery = new Query(Criteria.where("_id").is(post.getId()));
		LOGGER.info("Before updating post "+post);
		Update update = new Update();
		update.set("title", post.getTitle());
		update.set("category", post.getCategory());
		update.set("content", post.getContent());
		update.set("lastUpdationDate",new Date());
		update.set("tags", post.getTags());
	
		mongoTemplate.updateFirst(searchPostQuery, update, Post.class);
		return true;
	}

	public List<Post> getPostsByCategory(final String category) throws BlogException {
		if(category == null ||category.length() == 0){
			return getAll();
		}
		Query query = new Query(Criteria.where("category").is(category));
			return mongoTemplate.find(query, Post.class);
	}
	
	public void updateHitCount(String postId){
		Query query = new Query(Criteria.where("_id").is(postId));
		mongoTemplate.updateFirst(query, new Update().inc("hitCount", 1), Post.class);
	}
	
	public boolean updatePostRating(final String postId,final Rate rate){
		Query query = new Query(Criteria.where("_id").is(postId));
		Post post = mongoTemplate.findOne(query, Post.class);
		Update update= new Update();
		if(post != null){
			int totalRatings = 0;
			Set<Rate> rates = post.getRate();
			//If userId already exists in the rates set, then show "rating already exists rating" alert
			if(rates != null && rates.size()>0){
				totalRatings = rates.size();
				if(rates.contains(rate))
				return false;
			}
			float previousRating = post.getAverageRating();
			float newRating = rate.getRate();
			if(previousRating > 0){
				newRating = (previousRating*totalRatings + newRating)/(totalRatings+1);
			}
			
			update.set("rating",Math.round(newRating));
			update.set("averageRating", newRating);
			update.push("rate", rate);
			mongoTemplate.updateFirst(query,update, Post.class);
			return true;
		}
		return false;
	}

	public Page<Post> getPostListBySearch(JsonRequest jsonRequest) {
		final Filter filter = jsonRequest.getFilter();
		final Pageable pageable = jsonRequest.getPageRequest();
		final IncludeList includeList = jsonRequest.getIncludeList();
		LOGGER.info("searchString = {"+filter+"}  Page Request = {"+pageable+"}  Include list = {"+includeList+"}");
		Query query = null;
		String searchString = null;
		Page<Post> pages = null;
		if(filter != null && filter.getMappings().size() > 0){
			Set<Mapper> mappings = filter.getMappings();
			if(mappings != null && mappings.size() > 0){
				for (Mapper projection : mappings) {
					searchString = (String) projection.getValue();
				}
				
			}
			query = new Query(Criteria.where("title").regex(searchString).orOperator(Criteria.where("content").regex(searchString)));
		}
		else{
			query = new Query();
		}
		if(includeList != null && includeList.getFields().size() > 0){
			listFields(query, includeList);
		}
		
		if(pageable != null){
			long count = mongoTemplate.count(query, Post.class);
			pages = new PageImpl<Post>(mongoTemplate.find(paginate(query, pageable), Post.class), pageable, count);
		}
		
		return pages;
		
	
	}
}
