package com.dineromail.blackberry.enums.cl;

import com.dineromail.blackberry.model.PaymentMethod;

public class PaymentMethodCl implements PaymentMethod{

	public static String ALL = "all";
	public static String VISA = "cl_visa";
	public static String SERVIPAG = "cl_servipag";
	public static String RIPLEY = "cl_ripley";
	public static String PRESTO = "cl_presto";
	public static String MASTER = "cl_master";
	public static String MAGNA = "cl_magna";
	public static String DM = "cl_dm";
	public static String DINERS = "cl_diners";
	public static String AMEX = "cl_amex";

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public PaymentMethodCl(String value) {
		super();
		this.value = value;
	}
}
