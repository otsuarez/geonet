package com.dineromail.blackberry;

import java.util.Hashtable;

import net.rim.device.api.browser.field2.BrowserField;
import net.rim.device.api.browser.field2.BrowserFieldConfig;
import net.rim.device.api.browser.field2.BrowserFieldListener;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.container.MainScreen;

import org.w3c.dom.Document;

import com.dineromail.blackberry.model.DineroMail;
import com.dineromail.blackberry.views.LoadingDialog;

public class DineroMailScreen extends MainScreen {

	private LoadingDialog loadingDialog;

	private DineroMail dineroMail;

	private BrowserField browserField;

	public DineroMailScreen(DineroMail dineroMail, String backText) {
		BrowserFieldConfig myBrowserFieldConfig = new BrowserFieldConfig();

		this.dineroMail = dineroMail;
		browserField = new BrowserField(myBrowserFieldConfig);

		browserField.addListener(new BrowserFieldListener() {
			public void documentLoaded(BrowserField browserField,
					Document document) throws Exception {
				super.documentLoaded(browserField, document);
			}
		});

		loadingDialog = new LoadingDialog("Loading...");

		if (backText == null || backText.equals("")) {
			backText = "Back";
		}
		ButtonField buttonBack = new ButtonField(backText,
				ButtonField.CONSUME_CLICK);
		buttonBack.setChangeListener(new ClickBackButton());
		buttonBack.setMargin(10, 10, 10, 10);

		add(buttonBack);
		add(browserField);

		browserField.setFocus();

		BrowserFieldListener listener = new BrowserFieldListener() {
			public void documentLoaded(BrowserField browserField,
					Document document) throws Exception {

				UiApplication.getUiApplication().invokeLater(new Runnable() {
					public void run() {
						loadingDialog.close();
					}
				});
			}
		};
		browserField.addListener(listener);

		startThread();
	}

	public void startThread() {

		UiApplication.getUiApplication().invokeLater(new Runnable() {
			public void run() {
				loadingDialog.show();
			}
		});

		Thread t = new Thread() {
			public void run() {
				String postData = dineroMail.checkout();
				Hashtable headers = new Hashtable();
				headers.put("Content-Length", "" + postData.length());
				headers
						.put("Content-Type",
								"application/x-www-form-urlencoded");
				String baseURL = "https://testcheckoutmobile.dineromail.com/CheckOut";
				browserField.requestContent(baseURL, postData.getBytes(),
						headers);

			}
		};
		t.start();

	}

	public class ClickBackButton implements FieldChangeListener {
		public void fieldChanged(Field field, int context) {
			UiApplication.getUiApplication().popScreen(DineroMailScreen.this);
		}
	}

}
