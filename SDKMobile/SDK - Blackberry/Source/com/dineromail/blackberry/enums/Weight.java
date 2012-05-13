package com.dineromail.blackberry.enums;

public class Weight {

	public static String KG = "kg";
	public static String LB = "lb";

	private String value;

	public String getValue() {
		return value;
	}

	public Weight(String value) {
		super();
		this.value = value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}