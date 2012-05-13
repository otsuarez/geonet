package com.dineromail.blackberry.model;

import net.rim.device.api.util.Arrays;

import com.dineromail.blackberry.enums.Country;
import com.dineromail.blackberry.enums.Language;
import com.dineromail.blackberry.enums.ar.PaymentMethodAr;
import com.dineromail.blackberry.enums.br.CurrencyBr;
import com.dineromail.blackberry.enums.br.PaymentMethodBr;

public class DineroMailBr extends DineroMail {

	private Payment[] paymentMethodsAvailable;

	// Means of payment variables
	private PaymentMethodBr paymentMethodDefault;

	private CurrencyBr currency;

	/**
	 * Default to: Country.BRAZIL, Currency.BRL, Language.PT
	 */
	public DineroMailBr() {
		country = new Country(Country.BRAZIL);
		setCurrency(new CurrencyBr(CurrencyBr.BRL));
		language = new Language(Language.PT);
		paymentMethodsAvailable = new Payment[0];
	}

	public PaymentMethodBr getPaymentMethodDefault() {
		return paymentMethodDefault;
	}

	public String getPaymentMethodDefaultAsString() {
		if (paymentMethodDefault != null) {
			return paymentMethodDefault.getValue();
		}
		return "";
	}

	public String getCurrencyAsString() {
		if (currency != null) {
			return currency.getValue();
		}
		return "";
	}

	/**
	 * Pre selected default payment method. For example, if you want to pre
	 * select VISA: PaymentMethodBr.VISA= “br_visa”. If you don’t want to see
	 * any pre selected methods, you should leave this parameter null.
	 * 
	 * @param paymentMethodOne
	 */
	public void setPaymentMethodDefault(PaymentMethodBr paymentMethodDefault) {
		this.paymentMethodDefault = paymentMethodDefault;
	}

	/**
	 * adds a payment method with any desired installments
	 * 
	 * @param paymentMethod
	 * @param installments
	 */
	public void addPaymentMethod(PaymentMethodBr paymentMethod,
			int[] installments) {
		Payment payment = new Payment(paymentMethod, installments);
		Arrays.add(paymentMethodsAvailable, payment);
	}

	/**
	 * adds a payment method with no specific installments. All will be offered.
	 * 
	 * @param paymentMethod
	 * @param installments
	 */
	public void addPaymentMethod(PaymentMethodBr paymentMethod) {
		int[] inst = new int[0];
		Payment payment = new Payment(paymentMethod, inst);
		Arrays.add(paymentMethodsAvailable, payment);

	}

	public boolean validateMandatoryFields() {
		boolean passedMainFields = super.validateMandatoryFields();
		if (!passedMainFields) {
			return false;
		}
		if (paymentMethodsAvailable.length == 0) {
			return false;
		}
		return true;
	}

	public String getPaymentMethodsAsString() {
		String methods = "";
		int j = 0;
		for (int h = 0; h < paymentMethodsAvailable.length; h++) {
			Payment payment = paymentMethodsAvailable[h];

			PaymentMethodAr methodAr = (PaymentMethodAr) payment
					.getPaymentMethod();
			methods += methodAr.getValue();
			if (payment.getInstallments() != null) {
				int i = 0;
				for (int k = 0; k < payment.getInstallments().length; k++) {
					int val = payment.getInstallments()[k];
					methods += ",";
					if (i == payment.getInstallments().length - 1) {
						methods += val;
					} else {
						methods += val + ",";
					}
					i++;
				}
			}
			if (j != paymentMethodsAvailable.length - 1) {
				methods += ";";
			}
			j++;
		}
		return methods;
	}

	/**
	 * Brazilian currency.
	 * 
	 * @param currency
	 */
	public void setCurrency(CurrencyBr currency) {
		this.currency = currency;
	}

	public CurrencyBr getCurrency() {
		return currency;
	}

}
