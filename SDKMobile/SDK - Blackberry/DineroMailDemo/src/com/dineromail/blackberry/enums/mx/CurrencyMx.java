package com.dineromail.blackberry.enums.mx;

public class CurrencyMx {

	public static String ARS = "ars";
	public static String MXN = "mxn";
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public CurrencyMx(String value) {
		super();
		this.value = value;
	}
}
