package com.dineromail.blackberry.enums;

public class BuyerCountry {

	public static String ARGENTINA = "arg";
	public static String MEXICO = "mex";
	public static String CHILE = "chl";
	public static String BRAZIL = "bra";
	
	private String value;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public BuyerCountry(String value) {
		super();
		this.value = value;
	}
}
