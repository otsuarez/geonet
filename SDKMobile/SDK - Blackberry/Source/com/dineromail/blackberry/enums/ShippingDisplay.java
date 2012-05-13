package com.dineromail.blackberry.enums;

public class ShippingDisplay {
	public static int HIDE = 0;
	public static int SHOW = 1;
	
	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public ShippingDisplay(int value) {
		super();
		this.value = value;
	}
}
