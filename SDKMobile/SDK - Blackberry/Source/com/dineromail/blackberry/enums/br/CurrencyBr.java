package com.dineromail.blackberry.enums.br;

public class CurrencyBr {


	public static String BRL = "brl";
	public static String USD = "usd";
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public CurrencyBr(String value) {
		super();
		this.value = value;
	}
}
