package com.dineromail.blackberry.utils;

import javax.microedition.global.Formatter;

public class StringUtils {
	
	public static boolean isEmptyString(String value) {
		return value == null || "".equals(value.trim());
	}
	
	public static String doubleToString(double value) {
		Formatter formatter = new Formatter();
		return formatter.formatNumber(value, 2);
	}
}

