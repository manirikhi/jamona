package com.ems.blog.model;

public enum MonthOfYear {
	JANUARY("JANUARY","Jan"),FEBRUARY("FEBRUARY","Feb"),MARCH("MARCH","March"),APRIL("APRIL","Apr"),
	MAY("MAY","May"),JUNE("JUNE","Jun"),JULY("JULY","Jul"),AUGUST("AUGUST","Aug"),SEPTEMBER("SEPTEMBER","Sep"),
	OCTOBER("OCTOBER","Oct"),NOVEMBER("NOVEMBER","Nov"),DECEMBER("DECEMBER","Dec");
	
	private String longName;
	private String shortName;
	
	MonthOfYear(String longName,String shortName){
		this.longName = longName;
		this.shortName = shortName;
	}

	public String getLongName() {
		return longName;
	}

	public String getShortName() {
		return shortName;
	}

}
