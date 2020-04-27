package com.ems.blog.web.mvc.json;

public class Mapper {
	private String key;
	private Object value;
	/**
	 * @return the key
	 */
	public synchronized String getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public synchronized void setKey(String key) {
		this.key = key;
	}
	/**
	 * @return the value
	 */
	public synchronized Object getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public synchronized void setValue(Object value) {
		this.value = value;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Mapper [key=" + key + ", value=" + value + "]";
	}
	
}
