package com.dineromail.blackberry.enums.design;

public class HeaderWidth {
	public static int TOP_LEFT = 1;
	public static int ALL = 2;

	public int value;

	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
	public HeaderWidth(int value) {
		super();
		this.value = value;
	}

}
