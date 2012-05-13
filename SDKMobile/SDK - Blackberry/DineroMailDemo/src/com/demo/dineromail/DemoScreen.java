package com.demo.dineromail;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.util.Arrays;

import com.dineromail.blackberry.DineroMailScreen;
import com.dineromail.blackberry.enums.BuyerCountry;
import com.dineromail.blackberry.enums.ChangeQuantity;
import com.dineromail.blackberry.enums.Currency;
import com.dineromail.blackberry.enums.DocumentType;
import com.dineromail.blackberry.enums.Language;
import com.dineromail.blackberry.enums.Sex;
import com.dineromail.blackberry.enums.ShippingDisplay;
import com.dineromail.blackberry.enums.ShippingType;
import com.dineromail.blackberry.enums.Tool;
import com.dineromail.blackberry.enums.ar.PaymentMethodAr;
import com.dineromail.blackberry.enums.mx.PaymentMethodMx;
import com.dineromail.blackberry.model.DineroMailAr;
import com.dineromail.blackberry.model.DineroMailMx;
import com.dineromail.blackberry.model.Product;

public class DemoScreen extends MainScreen {

	public DemoScreen() {

		LabelField labelOne = new LabelField("Vista Checkout Simple (Ar): ",
				LabelField.FIELD_HCENTER);
		ButtonField buttonOne = new ButtonField("Checkout",
				ButtonField.CONSUME_CLICK);
		buttonOne.setChangeListener(new ClickOneButton());

		LabelField labelTwo = new LabelField(
				"Procesamiento de pago tipo gateway, se visualiza directamente la pantalla de resultado (Mx):",
				LabelField.FIELD_HCENTER);
		ButtonField buttonTwo = new ButtonField("Checkout",
				ButtonField.CONSUME_CLICK);
		buttonTwo.setChangeListener(new ClickTwoButton());

		add(labelOne);
		add(buttonOne);
		add(labelTwo);
		add(buttonTwo);

	}

	public class ClickOneButton implements FieldChangeListener {
		public void fieldChanged(Field field, int context) {

			DineroMailAr dineroMailExampleOne = new DineroMailAr();

			dineroMailExampleOne.setTool(new Tool(Tool.BUTTON));
			dineroMailExampleOne.setMerchant("dmoperator0001@hotmail.com");
			dineroMailExampleOne.setSellerName("IntegracionDineroMail");
			Product[] products = new Product[0];
			Product p = new Product();
			p.setName("Camera");
			p.setQuantity(1);
			p.setAmount(10000);
			p.setCurrency(new Currency(Currency.ARS));
			p.setShippingType(new ShippingType(ShippingType.NOT_AVAILABLE));
			p.setShippingCurrency(new Currency(Currency.ARS));
			Arrays.add(products, p);
			dineroMailExampleOne.setProducts(products);
			dineroMailExampleOne.addPaymentMethod(new PaymentMethodAr(
					PaymentMethodAr.ALL));
			dineroMailExampleOne.setLanguage(new Language(Language.EN));
			dineroMailExampleOne.setChangeQuantity(new ChangeQuantity(
					ChangeQuantity.NO_MODIFICATION_ALLOWED));

			if (dineroMailExampleOne.validateMandatoryFields()) {
				UiApplication.getUiApplication().pushScreen(
						new DineroMailScreen(dineroMailExampleOne, "Return"));
			} else {
				// Display error
			}

		}
	}

	public class ClickTwoButton implements FieldChangeListener {
		public void fieldChanged(Field field, int context) {
			DineroMailMx dineroMailExampleTwo = new DineroMailMx();

			dineroMailExampleTwo.setTool(new Tool(Tool.BUTTON));
			dineroMailExampleTwo.setMerchant("dmoperator0001@hotmail.com");
			dineroMailExampleTwo.setSellerName("Integración Dinero Mail");
			Product[] products = new Product[0];
			Product p = new Product();
			p.setName("Camera Panasonic Lumix Fz35 12.1Mp");
			p.setQuantity(1);
			p.setAmount(10000);
			p.setCurrency(new Currency(Currency.MXN));
			p.setShippingType(new ShippingType(ShippingType.FIXED_COST));

			p.setShippingCostDefault(1);
			p.setShippingCurrency(new Currency(Currency.MXN));
			Arrays.add(products, p);
			dineroMailExampleTwo.setProducts(products);
			dineroMailExampleTwo.addPaymentMethod(new PaymentMethodMx(
					PaymentMethodMx.OXXO));
			dineroMailExampleTwo.setPaymentMethodDefault(new PaymentMethodMx(
					PaymentMethodMx.OXXO));
			dineroMailExampleTwo.setLanguage(new Language(Language.EN));
			dineroMailExampleTwo.setChangeQuantity(new ChangeQuantity(
					ChangeQuantity.NO_MODIFICATION_ALLOWED));
			dineroMailExampleTwo.setDisplayShipping(new ShippingDisplay(
					ShippingDisplay.SHOW));
			dineroMailExampleTwo.setOkUrl("http://www.hotmail.com");
			dineroMailExampleTwo.setErrorUrl("http://www.gmail.com");
			dineroMailExampleTwo.setPendingUrl("http://www.yahoo.com");

			dineroMailExampleTwo.setBuyerName("Nombre");
			dineroMailExampleTwo.setBuyerLastName("Apellido");
			dineroMailExampleTwo.setBuyerSex(new Sex(Sex.MALE));
			dineroMailExampleTwo.setBuyerNationality(new BuyerCountry(
					BuyerCountry.ARGENTINA));
			dineroMailExampleTwo.setBuyerDocumentType(new DocumentType(
					DocumentType.DNI));
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
			dineroMailExampleTwo.setBuyerCountry(new BuyerCountry(
					BuyerCountry.ARGENTINA));

			if (dineroMailExampleTwo.validateMandatoryFields()) {
				UiApplication.getUiApplication().pushScreen(
						new DineroMailScreen(dineroMailExampleTwo, "Return"));
			} else {
				// Display error
			}
		}
	}
}
