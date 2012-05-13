package com.dineromail.blackberry.enums.design;

public class ExpandedStepAD {

	public static int FOLDED = 0;
	public static int UNFLODED = 1;

	public int value;

	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
	public ExpandedStepAD(int value) {
		super();
		this.value = value;
	}

}
