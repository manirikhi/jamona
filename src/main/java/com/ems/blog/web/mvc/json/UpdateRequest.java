package com.ems.blog.web.mvc.json;

import java.util.HashSet;
import java.util.Set;

public class UpdateRequest {
	private Filter filter;
	private Set<UpdateMapper> mappings = new HashSet<UpdateMapper>();
	/**
	 * @return the filter
	 */
	public Filter getFilter() {
		return filter;
	}
	/**
	 * @param filter the filter to set
	 */
	public void setFilter(Filter filter) {
		this.filter = filter;
	}
	/**
	 * @return the mappings
	 */
	public Set<UpdateMapper> getMappings() {
		return mappings;
	}
	/**
	 * @param mappings the mappings to set
	 */
	public void setMappings(Set<UpdateMapper> mappings) {
		this.mappings = mappings;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UpdateRequest [filter=" + filter + ", mappings=" + mappings
				+ "]";
	};
	
}
