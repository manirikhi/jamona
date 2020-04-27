package com.ems.blog.web.mvc.json;

import java.util.HashSet;
import java.util.Set;

public class IncludeList {
	private Set<String> fields = new HashSet<String>();

	/**
	 * @return the fields
	 */
	public Set<String> getFields() {
		return fields;
	}

	/**
	 * @param fields the fields to set
	 */
	public void setFields(Set<String> fields) {
		this.fields = fields;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Field [fields=" + fields + "]";
	}
	
	
}
