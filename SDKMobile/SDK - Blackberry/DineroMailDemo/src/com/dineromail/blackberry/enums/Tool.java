package com.dineromail.blackberry.enums;

public class Tool {
	public static String BUTTON = "button";
	public static String CART = "cart";
	
	private String value;

	public String getValue() {
		return value;
	}

	public Tool(String value) {
		super();
		this.value = value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
