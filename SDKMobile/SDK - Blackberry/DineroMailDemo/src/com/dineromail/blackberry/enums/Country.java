package com.dineromail.blackberry.enums;

public class Country {
	public static int ARGENTINA = 1;
	public static int BRAZIL = 2;
	public static int CHILE = 3;
	public static int MEXICO = 4;
	
	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public Country(int value) {
		super();
		this.value = value;
	}
}
