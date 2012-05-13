package com.dineromail.blackberry.enums.ar;

public class CurrencyAr {

	public static String ARS = "ars";
	public static String USD = "usd";
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public CurrencyAr(String value) {
		super();
		this.value = value;
	}
}
