package com.ems.blog.dao;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.ems.blog.exception.BlogException;
import com.ems.blog.web.mvc.json.Filter;
import com.ems.blog.web.mvc.json.IncludeList;
import com.ems.blog.web.mvc.json.JsonRequest;
import com.ems.blog.web.mvc.json.Mapper;
import com.ems.blog.web.mvc.json.UpdateMapper;
import com.ems.blog.web.mvc.json.UpdateOperationType;
import com.ems.blog.web.mvc.json.UpdateRequest;

public abstract class AbstractDAO<T> implements BlogDAO<T> {
	private static final Logger LOGGER = Logger.getLogger(AbstractDAO.class);
	private static final String PASSWORD_FIELD = "PASSWORD";
	private Class<T> clazz;
	protected MongoTemplate mongoTemplate;
	

	public AbstractDAO(Class<T> class1) {
		this();
		this.clazz = class1;
	}
	public AbstractDAO() {
		super();
	}
	/**
	 * @return the mongoTemplate
	 */
	public synchronized MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}


	/**
	 * @param mongoTemplate the mongoTemplate to set
	 */
	@Autowired
	public synchronized void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	   @SuppressWarnings( "deprecation" )
	    protected Query sort(final Query query, final Sort sort) {

	        if (sort == null) {
	            return query;
	        }

	        //final org.springframework.data.mongodb.core.query.Sort bSort = query.sort();

	        /*for (final Sort.Order order : sort) {
	            bSort.on(order.getProperty(), toOrder(order));
	        }*/

	        return query;
	    }
	    
	    protected Query paginate(final Query query, final Pageable pageable) {
	        if (pageable == null) {
	            return query;
	        }

	        query.skip(pageable.getOffset()).limit(pageable.getPageSize());

	        return this.sort(query, pageable.getSort());
	    }
	    
	    protected org.springframework.data.mongodb.core.query.Order toOrder(final Sort.Order order) {
	        return order.isAscending() ? org.springframework.data.mongodb.core.query.Order.ASCENDING
	                : org.springframework.data.mongodb.core.query.Order.DESCENDING;
	    }

	public boolean create(T t) throws BlogException{
		mongoTemplate.save(t);
		LOGGER.info("Save the Entity in db"+t);
		return true;
	}

	public boolean deleteById(final String id) throws BlogException{
		if(id == null)
			return false;
		Query query = new Query(new Criteria("_id").is(id));
		mongoTemplate.remove(query,clazz);
		LOGGER.info("Entity is deleted from db"+id);
		return true;
	}


	public List<T> getAll() throws BlogException{
		return mongoTemplate.findAll(clazz);
	}
	
	public T getById(final String id) throws BlogException{
		return mongoTemplate.findById(id, clazz);
	}
	
	public Page<T> getCollection(final JsonRequest jsonRequest) throws BlogException{
		final Filter filter = jsonRequest.getFilter();
		final Pageable pageable = jsonRequest.getPageRequest();
		final IncludeList includeList = jsonRequest.getIncludeList();
		LOGGER.info("Filter = {"+filter+"}  Page Request = {"+pageable+"}  Include list = {"+includeList+"}");
		Criteria criteria = null;
		Query query = null;
		Page<T> pages = null;
		if(filter != null && filter.getMappings().size() > 0){
			criteria = listFilter(filter);
			if(criteria == null)
				query = new Query();
			else
				query = new Query(criteria);
		}
		else{
			query = new Query();
		}
		if(includeList != null && includeList.getFields().size() > 0){
			listFields(query, includeList);
		}
		
		if(pageable != null){
			long count = mongoTemplate.count(query, clazz);
			pages = new PageImpl<T>(mongoTemplate.find(paginate(query, pageable), clazz), pageable, count);
		}
		
		return pages;
		
	}
	
	private Criteria listFilter(Filter filter){
		Criteria criteriaObject = null;
		if(filter != null){
			Set<Mapper> mappings = filter.getMappings();
			if(mappings != null && mappings.size() > 0){
				for (Mapper projection : mappings) {
					if(criteriaObject == null)
						criteriaObject = Criteria.where(projection.getKey()).is(projection.getValue());
					else
						criteriaObject.and(projection.getKey()).is(projection.getValue());
				}
			}
		}
		return criteriaObject;
	}
	
	protected void listFields(Query query,IncludeList field){
		if(field != null){
			Set<String> fields= field.getFields();
			for (String  string: fields) {
				if(PASSWORD_FIELD.equalsIgnoreCase(string))
				query.fields().include(string);
			}
		}		
	}
	
	public boolean updateDocument(final UpdateRequest updateRequest) throws BlogException{
		if(updateRequest != null){
			Criteria criteria = null;
			Query query = null;
			Update update = null;
			Filter filter = updateRequest.getFilter();
			if(filter != null && filter.getMappings().size() > 0){
				criteria = listFilter(filter);
				query = new Query(criteria);
			}
			else{
				return false;
			}
			
			Set<UpdateMapper> mappings = updateRequest.getMappings();
			LOGGER.info("updateRequest = "+updateRequest);
			if(mappings == null || mappings.size() == 0){
				return false;
			}
			try {
				update = listUpdateMappings(mappings);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(update == null){
				return false;
			}
			mongoTemplate.updateFirst(query, update, clazz);
			return true;
		}
		return false;
		
	}
	
	private Update listUpdateMappings(final Set<UpdateMapper> mappings) throws BlogException, ClassNotFoundException, JsonParseException, JsonMappingException, IOException {
		Update update = new Update();
		for (UpdateMapper updateMapper : mappings) {
			
			UpdateOperationType oper = updateMapper.getOper();
			String key = updateMapper.getKey();
			String className = updateMapper.getType();
			Class<?> cls = Class.forName(className);
			JsonNode value = updateMapper.getValue();
			Object object = jsonConverter(cls,value);
			if(oper == null || key == null || key.trim().equals("") || !validateField(key) || object == null){
				return null;
			}
				switch (oper) {
				case set:
					update.set(key,object);
					break;
				case inc:
					try {
						Number increment = Integer.valueOf(object+"");
						LOGGER.info("Number value in inc = "+increment);
						update.inc(key, increment);
					} catch (Exception e) {
						throw new BlogException("Please provide any integer value for increment Operation. value = "+value);
					}
					break;
				case addToSet:
					update.addToSet(key, object);
					break;
				case push:
					update.push(key, object);
					break;	
				case pull:
					update.pull(key, object);
					break;	
				default:
					return null;
				}
			
		}	
		return update;
	}
	
	private boolean validateField(final String fieldName){
		Field [] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			if(field.getName().equals(fieldName))
				LOGGER.info("Field Type" +field.getType());
				return true;
		}
		return false;
	}
	
	private Object jsonConverter(Class<?> className,JsonNode value) throws ClassNotFoundException, JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(value, className);
	}
}
