package com.demo.dineromail;

import net.rim.device.api.ui.UiApplication;

public class MainUI extends UiApplication {

	public static void main(String[] args) {
		MainUI theApp = new MainUI();
		theApp.enterEventDispatcher();

	}

	public MainUI() {
		pushScreen(new DemoScreen());
	}

}
