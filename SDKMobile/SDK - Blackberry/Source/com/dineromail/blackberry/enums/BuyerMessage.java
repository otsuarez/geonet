package com.dineromail.blackberry.enums;

public class BuyerMessage {
	public static int ALLOW_BUYER_MESSAGE = 0;
	public static int PREVENT_BUYER_MESSAGE = 1;
	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public BuyerMessage(int value) {
		super();
		this.value = value;
	}
}
