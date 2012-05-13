package com.dineromail.blackberry.enums;

public class DocumentType {

	public static String CPF = "cpf";
	public static String CNPJ = "cnpj";
	public static String RUT = "rut";
	public static String DNI = "dni";
	public static String CUIL = "cuil";
	public static String CUIT = "cuit";
	public static String LE = "le";
	public static String LC = "lc";
	public static String RFC = "rfc";
	public static String CURP = "curp";
	public static String IFE = "ife";
	public static String LIC = "lic";
	
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public DocumentType(String value) {
		super();
		this.value = value;
	}

}
