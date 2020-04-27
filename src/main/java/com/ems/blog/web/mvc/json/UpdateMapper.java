package com.ems.blog.web.mvc.json;

import org.codehaus.jackson.JsonNode;

public class UpdateMapper {
	private String key;
	private JsonNode value;
	private UpdateOperationType oper;
	private String type;
	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
	
	/**
	 * @return the value
	 */
	public JsonNode getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(JsonNode value) {
		this.value = value;
	}
	/**
	 * @return the oper
	 */
	public UpdateOperationType getOper() {
		return oper;
	}
	/**
	 * @param oper the oper to set
	 */
	public void setOper(UpdateOperationType oper) {
		this.oper = oper;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UpdateMapper [key=" + key + ", value=" + value + ", oper="
				+ oper + ", type=" + type + "]";
	}

}
