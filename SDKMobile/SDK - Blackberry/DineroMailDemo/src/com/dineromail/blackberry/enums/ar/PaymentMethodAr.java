package com.dineromail.blackberry.enums.ar;

import com.dineromail.blackberry.model.PaymentMethod;

public class PaymentMethodAr implements PaymentMethod{

	public static String ALL = "all";
	public static String AMEX = "ar_amex";
	public static String ARGENCARD = "ar_argencard";
	public static String BANKTRANSFER = "ar_banktransfer";
	public static String BAPROPAGO = "ar_bapropago";
	public static String CABAL = "ar_cabal";
	public static String COBROEXPRESS = "ar_cobroexpress";
	public static String DM = "ar_dm";
	public static String ITEALCRED = "ar_italcred";
	public static String PAGOFACIL = "ar_pagofacil";
	public static String RAPIPAGO = "ar_rapipago";
	public static String TNARANJA = "ar_tnaranja";
	public static String TSHOPPING = "ar_tshopping";
	public static String VISA = "ar_visa";
	
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public PaymentMethodAr(String value) {
		super();
		this.value = value;
	}
}
