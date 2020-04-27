package com.ems.blog.web.mvc.json;


public class JsonRequest {
	private PageRequest pageRequest;
	private Filter filter;
	private IncludeList includeList;
	
	/**
	 * @return the pageRequest
	 */
	public PageRequest getPageRequest() {
		return pageRequest;
	}
	/**
	 * @param pageRequest the pageRequest to set
	 */
	public void setPageRequest(PageRequest pageRequest) {
		this.pageRequest = pageRequest;
	}
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
	 * @return the includeList
	 */
	public IncludeList getIncludeList() {
		return includeList;
	}
	/**
	 * @param includeList the includeList to set
	 */
	public void setIncludeList(IncludeList includeList) {
		this.includeList = includeList;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JsonRequest [pageRequest=" + pageRequest + ", filter=" + filter
				+ ", includeList=" + includeList + "]";
	}
	
}
