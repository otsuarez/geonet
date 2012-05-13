package com.android.demo;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.dineromail.android.DineroMailActivity;
import com.dineromail.android.enums.BuyerCountry;
import com.dineromail.android.enums.ChangeQuantity;
import com.dineromail.android.enums.Currency;
import com.dineromail.android.enums.DocumentType;
import com.dineromail.android.enums.Language;
import com.dineromail.android.enums.Sex;
import com.dineromail.android.enums.ShippingDisplay;
import com.dineromail.android.enums.ShippingType;
import com.dineromail.android.enums.Tool;
import com.dineromail.android.enums.ar.PaymentMethodAr;
import com.dineromail.android.enums.mx.PaymentMethodMx;
import com.dineromail.android.model.DineroMailAr;
import com.dineromail.android.model.DineroMailMx;
import com.dineromail.android.model.Product;

public class SimpleDemoActivity extends Activity {


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demo);
	}

	public void triggerDineroMailExampleOne(View v) {

		DineroMailAr dineroMailExampleOne = new DineroMailAr();

		dineroMailExampleOne.setTool(Tool.BUTTON);
		dineroMailExampleOne.setMerchant("dmoperator0001@hotmail.com");
		dineroMailExampleOne.setSellerName("Integraci—n Dinero Mail");
		ArrayList<Product> products = new ArrayList<Product>();
		Product p = new Product();
		p.setName("Camera Panasonic Lumix Fz35 12.1Mp");
		p.setQuantity(1);
		p.setAmount(10000);
		p.setCurrency(Currency.ARS);
		p.setShippingType(ShippingType.NOT_AVAILABLE);
		p.setShippingCurrency(Currency.ARS);
		products.add(p);
		dineroMailExampleOne.setProducts(products);
		dineroMailExampleOne.addPaymentMethod(PaymentMethodAr.ALL);
		dineroMailExampleOne.setLanguage(Language.EN);
		dineroMailExampleOne
				.setChangeQuantity(ChangeQuantity.NO_MODIFICATION_ALLOWED);

		if (dineroMailExampleOne.validateMandatoryFields()) {
			Intent i = dineroMailExampleOne.checkout(this);
			i.putExtra(DineroMailActivity.BUTTON_BACK_PARAM,
					"Go back to my app");
			startActivityForResult(i, 0);
		} else {
			showSimpleMessage(
					"Error",
					"Validation failed. Remember to set the merchant, country and at least one payment method.");
		}
	}

	public void triggerDineroMailExampleTwo(View v) {

		DineroMailMx dineroMailExampleTwo = new DineroMailMx();

		dineroMailExampleTwo.setTool(Tool.BUTTON);
		dineroMailExampleTwo.setMerchant("dmoperator0001@hotmail.com");
		dineroMailExampleTwo.setSellerName("Integraci—n Dinero Mail");
		ArrayList<Product> products = new ArrayList<Product>();
		Product p = new Product();
		p.setName("Camera Panasonic Lumix Fz35 12.1Mp");
		p.setQuantity(1);
		p.setAmount(10000);
		p.setCurrency(Currency.MXN);
		p.setShippingType(ShippingType.FIXED_COST);
		p.setShippingCostDefault(1);
		p.setShippingCurrency(Currency.MXN);
		products.add(p);
		dineroMailExampleTwo.setProducts(products);
		dineroMailExampleTwo.addPaymentMethod(PaymentMethodMx.OXXO);
		dineroMailExampleTwo.setPaymentMethodDefault(PaymentMethodMx.OXXO);
		dineroMailExampleTwo.setLanguage(Language.EN);
		dineroMailExampleTwo
				.setChangeQuantity(ChangeQuantity.NO_MODIFICATION_ALLOWED);
		dineroMailExampleTwo.setDisplayShipping(ShippingDisplay.SHOW);
		dineroMailExampleTwo.setOkUrl("http://www.hotmail.com");
		dineroMailExampleTwo.setErrorUrl("http://www.gmail.com");
		dineroMailExampleTwo.setPendingUrl("http://www.yahoo.com");

		dineroMailExampleTwo.setBuyerName("Nombre");
		dineroMailExampleTwo.setBuyerLastName("Apellido");
		dineroMailExampleTwo.setBuyerSex(Sex.MALE);
		dineroMailExampleTwo.setBuyerNationality(BuyerCountry.ARGENTINA);
		dineroMailExampleTwo.setBuyerDocumentType(DocumentType.DNI);
		dineroMailExampleTwo.setBuyerDocumentNumber("12345678");
		dineroMailExampleTwo.setBuyerEmail("test@test.com");
		dineroMailExampleTwo.setBuyerPhone("55555555");
		dineroMailExampleTwo.setBuyerPhoneExtension("123");
		dineroMailExampleTwo.setBuyerZipCode("1234");
		dineroMailExampleTwo.setBuyerStreet("buyer_street");
		dineroMailExampleTwo.setBuyerNumber("123");
		dineroMailExampleTwo.setBuyerComplement("buyer_complement");
		dineroMailExampleTwo.setBuyerCity("buyer_city");
		dineroMailExampleTwo.setBuyerState("buyer_state");
		dineroMailExampleTwo.setBuyerCountry(BuyerCountry.ARGENTINA);

		if (dineroMailExampleTwo.validateMandatoryFields()) {
			Intent i = dineroMailExampleTwo.checkout(this);
			i.putExtra(DineroMailActivity.BUTTON_BACK_PARAM, "Back to demo");
			startActivityForResult(i, 0);
		} else {
			showSimpleMessage(
					"Error",
					"Validation failed. Remember to set the merchant, country and at least one payment method.");
		}
	}

	private void showSimpleMessage(String title, String message) {
		Builder dialogBuilder = new AlertDialog.Builder(this);
		dialogBuilder.setTitle(title);
		dialogBuilder.setMessage(message);
		dialogBuilder.setPositiveButton("OK", null);
		dialogBuilder.show();
	}

	public void onActivityResult(int requestCode, int resultCode, Intent data) {

		switch (resultCode) {
		case DineroMailActivity.RESULT_CANCEL:
			Toast.makeText(this, "Action cancel...", Toast.LENGTH_LONG).show();
			break;
		case DineroMailActivity.RESULT_BACK:
			Toast.makeText(this, "Action back...", Toast.LENGTH_LONG).show();
			break;
		case DineroMailActivity.RESULT_SUCCESS:
			Toast.makeText(this, "Action success...", Toast.LENGTH_LONG).show();
			break;
		case DineroMailActivity.RESULT_ERROR:
			Toast.makeText(this, "Action error...", Toast.LENGTH_LONG).show();
			break;
		}

	}
}