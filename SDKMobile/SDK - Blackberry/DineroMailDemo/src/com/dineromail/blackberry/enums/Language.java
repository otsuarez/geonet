package com.dineromail.blackberry.enums;

public class Language {

	public static String ES = "es";
	public static String PT = "pt";
	public static String EN = "en";
	
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public Language(String value) {
		super();
		this.value = value;
	}
}
