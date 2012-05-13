package com.dineromail.blackberry.enums.br;

import com.dineromail.blackberry.model.PaymentMethod;

public class PaymentMethodBr implements PaymentMethod {

	public static String ALL = "all";
	public static String AMEX = "br_amex";
	public static String AURA = "br_aura";
	public static String VISA = "br_visa";
	public static String OIPAGGO = "br_oipaggo";
	public static String MASTER = "br_master";
	public static String HIPERCARD = "br_hipercard";
	public static String DM = "br_dm";
	public static String DINERS = "br_diners";
	public static String BBANCARIO = "br_bbancario";
	public static String BCO_BRASIL_DD = "br_bco_brasil_dd";
	public static String BCO_BRADESCO_DD = "br_bco_bradesco_dd";

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public PaymentMethodBr(String value) {
		super();
		this.value = value;
	}
}
