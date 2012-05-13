package com.dineromail.blackberry.enums;

public class ShippingType {

	public static int NOT_AVAILABLE = 0;
	public static int FIXED_COST = 1;
	public static int FIXED_QUANTITY_COST = 2;
	public static int WEIGHT = 3;
	
	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public ShippingType(int value) {
		super();
		this.value = value;
	}
}
