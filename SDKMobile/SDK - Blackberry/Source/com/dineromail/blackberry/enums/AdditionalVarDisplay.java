package com.dineromail.blackberry.enums;

public class AdditionalVarDisplay {
	public static int HIDE = 0;
	public static int SHOW = 1;

	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public AdditionalVarDisplay(int value) {
		super();
		this.value = value;
	}
}
