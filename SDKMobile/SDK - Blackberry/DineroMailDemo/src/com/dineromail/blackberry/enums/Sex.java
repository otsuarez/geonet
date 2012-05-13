package com.dineromail.blackberry.enums;

public class Sex {

	public static String MALE = "m";
	public static String FEMALE = "f";

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public Sex(String value) {
		super();
		this.value = value;
	}
}
