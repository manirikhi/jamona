package com.ems.blog.dao;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.ems.blog.exception.BlogException;
import com.ems.blog.model.User;

@Repository("blogUserDAO")
public class BlogUserDAO extends AbstractDAO<User> {
	private static final Logger LOGGER = Logger.getLogger(BlogUserDAO.class);

	public BlogUserDAO() {
		super(User.class);
	}

	public boolean update(User user) throws BlogException {
		Query searchuserQuery = new Query(Criteria.where("_id")
				.is(user.getId()));
		LOGGER.info("Before updating user " + user);
		Update update = new Update();
		update.set("firstName", user.getFirstName());
		update.set("lastName", user.getLastName());
		update.set("about", user.getAbout());
		update.set("lastModifiedOn", new Date());

		mongoTemplate.updateFirst(searchuserQuery, update, User.class);
		return true;
	}

	public User validateUser(String email) {
		LOGGER.info("Validating user " + email);
		Query query = new Query(Criteria.where("email").is(email));
		User user = mongoTemplate.findOne(query, User.class);
		LOGGER.info("User value = : " + user);
		return user;
	}
}
