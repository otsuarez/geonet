package com.dineromail.blackberry.enums.mx;

import com.dineromail.blackberry.model.PaymentMethod;

public class PaymentMethodMx implements PaymentMethod{

	public static String ALL = "all";
	public static String SCOTIABANK_TC = "mx_scotiabank_tc";
	public static String SCOTIABANK_TB = "mx_scotiabank_tb";
	public static String SCOTIABANK_DR = "mx_scotiabank_dr";
	public static String SANTANDER_TD = "mx_santander_td";
	public static String SANTANDER_TC = "mx_santander_tc";
	public static String SANTANDER_TB = "mx_santander_tb";
	public static String SANTANDER_DR = "mx_santander_dr";
	public static String OXXO = "mx_oxxo";
	public static String OTHERBANK_TC = "mx_otherbank_tc";
	public static String IXE_TC = "mx_ixe_tc";
	public static String IXE_TB = "mx_ixe_tb";
	public static String IXE_DR = "mx_ixe_dr";
	public static String HSBC_DR = "mx_hsbc_td";
	public static String HSBC_TD = "mx_hsbc_tb";
	public static String DM = "mx_dm";
	public static String BANORTE_TD = "mx_banorte_td";
	public static String BANCOMER_TD = "mx_bancomer_tc";
	public static String BANCOMER_TB = "mx_bancomer_tb";
	public static String BANCOMER_DR = "mx_bancomer_dr";
	public static String BANAMEX_TD = "mx_banamex_td";
	public static String AMEX = "mx_amex";
	public static String SEVEN_ELEVEN = "mx_7eleven";
	
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public PaymentMethodMx(String value) {
		super();
		this.value = value;
	}
}
