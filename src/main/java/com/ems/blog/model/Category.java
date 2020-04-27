package com.ems.blog.model;

public enum Category {
	NEWS("News"), TECHNO("Techno"), TRENDS("Trends"), PRODUCT("Product"), ENTERTAINMENT(
			"Entertainment"), SOCIAL("social"),MEN("Men"),WOMEN("Women");
	private String name;

	private Category(final String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
}
