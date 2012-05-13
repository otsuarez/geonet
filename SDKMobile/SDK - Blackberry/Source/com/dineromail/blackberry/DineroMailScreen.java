package com.dineromail.blackberry;

import java.util.Hashtable;

import net.rim.device.api.browser.field2.BrowserField;
import net.rim.device.api.browser.field2.BrowserFieldConfig;
import net.rim.device.api.browser.field2.BrowserFieldListener;
import net.rim.device.api.servicebook.ServiceBook;
import net.rim.device.api.servicebook.ServiceRecord;
import net.rim.device.api.system.CoverageInfo;
import net.rim.device.api.system.DeviceInfo;
import net.rim.device.api.system.WLANInfo;
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
	
	private  String URL =  "https://testcheckoutmobile.dineromail.com/CheckOut"  ;

	
	
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
		
		
		

		URL = URL + updateConnectionSuffix();
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
			 
				browserField.requestContent(URL, postData.getBytes(),
						headers);

			}
		};
		t.start();

	}
	 
	
	public static String updateConnectionSuffix() {
		String connectionString = null;
		if (DeviceInfo.isSimulator()) {
			connectionString = ";deviceside=true";
		} else if (WLANInfo.getWLANState() == WLANInfo.WLAN_STATE_CONNECTED) {
			connectionString = ";interface=wifi";
		} else if ((CoverageInfo.getCoverageStatus() & CoverageInfo.COVERAGE_DIRECT) == CoverageInfo.COVERAGE_DIRECT) {
			String carrierUid = getCarrierBIBSUid();
			if (carrierUid == null) {
				connectionString = ";deviceside=true";
			} else {
				connectionString = ";deviceside=false;connectionUID="
						+ carrierUid + ";ConnectionType=mds-public";
			}
		} else if ((CoverageInfo.getCoverageStatus() & CoverageInfo.COVERAGE_MDS) == CoverageInfo.COVERAGE_MDS) {
			connectionString = ";deviceside=false";
		} else if (CoverageInfo.getCoverageStatus() == CoverageInfo.COVERAGE_NONE) {
		} else {
			connectionString = ";deviceside=true";
		}
		return connectionString;
	}
	
	private static String getCarrierBIBSUid() {
		ServiceRecord[] records = ServiceBook.getSB().getRecords();
		int currentRecord;

		for (currentRecord = 0; currentRecord < records.length; currentRecord++) {
			if (records[currentRecord].getCid().toLowerCase().equals("ippp")) {
				if (records[currentRecord].getName().toLowerCase().indexOf(
						"bibs") >= 0) {
					return records[currentRecord].getUid();
				}
			}
		}
		return null;
	}

	public class ClickBackButton implements FieldChangeListener {
		public void fieldChanged(Field field, int context) {
			UiApplication.getUiApplication().popScreen(DineroMailScreen.this);
		}
	}

}
