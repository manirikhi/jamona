package com.ems.blog.dao;
import java.util.List;

import com.ems.blog.exception.BlogException;

public interface BlogDAO<T> {
	public boolean create(T t) throws BlogException;
	public boolean deleteById(final String id) throws BlogException;
	public boolean update(T t) throws BlogException;
	public List<T> getAll() throws BlogException;
	public T getById(final String id) throws BlogException;
}
