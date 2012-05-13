package com.dineromail.blackberry.enums.cl;

public class CurrencyCl {


	public static String ARS = "ars";
	public static String CLP = "clp";
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public CurrencyCl(String value) {
		super();
		this.value = value;
	}
}
