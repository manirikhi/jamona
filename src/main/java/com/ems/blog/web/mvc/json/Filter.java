package com.ems.blog.web.mvc.json;

import java.util.HashSet;
import java.util.Set;

public class Filter {
	private Set<Mapper> mappings= new HashSet<Mapper>();

	/**
	 * @return the mappings
	 */
	public Set<Mapper> getMappings() {
		return mappings;
	}

	/**
	 * @param mappings the mappings to set
	 */
	public void setMappings(Set<Mapper> mappings) {
		this.mappings = mappings;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Filter [mappings=" + mappings + "]";
	}
	
}
