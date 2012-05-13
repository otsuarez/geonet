package com.dineromail.blackberry.model;

 
public class Payment {

	private PaymentMethod paymentMethod;

	private int[] installments;

	public Payment(PaymentMethod paymentMethod, int[] installments) {
		super();
		this.paymentMethod = paymentMethod;
		this.installments = installments;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public int[] getInstallments() {
		return installments;
	}

	public void setInstallments(int[] installments) {
		this.installments = installments;
	}

}
