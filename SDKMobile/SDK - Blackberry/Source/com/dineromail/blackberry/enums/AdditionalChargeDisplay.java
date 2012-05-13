package com.dineromail.blackberry.enums;

public class AdditionalChargeDisplay {

	public static int HIDE = 0;
	public static int SHOW_FIXED = 1;
	public static int SHOW_VARIABLE = 2;

	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public AdditionalChargeDisplay(int value) {
		
		super();
		this.value = value;
	}
}
