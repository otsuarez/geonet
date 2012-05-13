package com.dineromail.blackberry.enums;

public class ChangeQuantity {
	public static int NO_MODIFICATION_ALLOWED = 0;
	public static int MODIFICATION_ALLOWED = 1;

	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public ChangeQuantity(int value) {
		super();
		this.value = value;
	}
}
