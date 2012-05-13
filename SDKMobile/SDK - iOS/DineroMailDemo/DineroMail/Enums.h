/*
 *  Enums.h
 *  PostWebView
 *
 *  Created on 9/8/11.
 *  Copyright 2011 DineroMail. All rights reserved.
 *
 */

#ifndef		__ENUMS_h__
#define		__ENUMS_h__

#define	CHECKOUT_URL		@"http://checkout.dineromail.com/CheckOut"

typedef	enum AdditionalChargeDisplay_T{
	HIDE, SHOW_FIXED, SHOW_VARIABLE
}AdditionalChargeDisplay;

typedef	enum AdditionalVarDisplay_T{
	VARDISPLAY_HIDE, VARDISPLAY_SHOW
}AdditionalVarDisplay;

typedef	enum BuyerMessage_T{
	ALLOW_BUYER_MESSAGE, PREVENT_BUYER_MESSAGE
}BuyerMessage;

typedef	enum ChangeQuantity_T{
	NO_MODIFICATION_ALLOWED, MODIFICATION_ALLOWED
}ChangeQuantity;

typedef	enum Country_T{
	ARGENTINA=1, BRAZIL=2, CHILE=3, MEXICO=4
}Country;

typedef	enum Currency_T{
	ARS, MXN, CLP, USD, BRL
}Currency;

typedef enum DocumentType_T{
	CPF, CNPJ, RUT, DNI, CUIL, CUIT, LE, LC, RFC, CURP, IFE, LIC
}DocumentType;

typedef enum Language_T{
	ES, PT, EN
}Language;

typedef enum SEX_T{
	MALE, FEMALE
}Sex;

typedef enum ShippingDisplay_T{
	SHIPDISPLAY_HIDE, SHIPDISPLAY_SHOW
}ShippingDisplay;

typedef enum ShippingType_T{
	ST_NOT_AVAILABLE, ST_FIXED_COST, ST_FIXED_QUANTITY_COST, ST_WEIGHT
}ShippingType;

typedef enum Tool_T
{
	BUTTON, CART
}Tool;

typedef enum Weight_T{
	KG, LB
}Weight;


extern NSString* CURRENCY[5];
extern NSString* BUYERCOUNTRY[5];
extern NSString* DOCUMENTTYPE[12];
extern NSString* LANGUAGE[3];
extern NSString* SEX[2];
extern NSString* TOOL[2];
extern NSString* WEIGHT[2];

//Enum design

typedef	enum	ExpandedSaleDetail_T{
	FOLDED,	UNFOLDED
}ExpandedSaleDetail, ExpandedStepPM, ExpandedStepAD, ExpandedStepSC;

//typedef ExpandedSaleDetail	ExpandedStepPM;


typedef	enum	HeaderWidth_T{
	TOP_LEFT=1,	ALL=2
}HeaderWidth;

typedef enum PaymentMethodAr_T{
	AR_ALL, AR_AMEX, AR_ARGENCARD, AR_BANKTRANSFER, AR_BAPROPAGO, AR_CABAL, AR_COBROEXPRESS, AR_DM, AR_ITEALCRED, AR_PAGOFACIL, AR_RAPIPAGO, AR_TNARANJA, AR_TSHOPPING, AR_VISA
}PaymentMethodAr;

typedef enum PaymentMethodBr_T{
	BR_ALL, BR_AMEX, BR_AURA, BR_VISA, BR_OIPAGGO, BR_MASTER, BR_HIPERCARD, BR_DM, BR_DINERS, BR_BBANCARIO, BR_BCO_BRASIL_DD, BR_BCO_BRADESCO_DD
}PaymentMethodBr;

typedef enum PaymentMethodCl_T{
	CL_ALL, CL_VISA, CL_SERVIPAG, CL_RIPLEY, CL_PRESTO, CL_MASTER, CL_MAGNA, CL_DM, CL_DINERS, CL_AMEX
}PaymentMethodCl;

typedef enum PaymentMethodMx_T{
	MX_ALL, MX_SCOTIABANK_TC, MX_SCOTIABANK_TB, MX_SCOTIABANK_DR, MX_SANTANDER_TD, MX_SANTANDER_TC, MX_SANTANDER_TB, MX_SANTANDER_DR, 
	MX_OXXO, MX_OTHERBANK_TC, MX_IXE_TC, MX_IXE_TB, MX_IXE_DR, MX_HSBC_DR, MX_HSBC_TD, MX_DM, 
	MX_BANORTE_TD, MX_BANCOMER_TD, MX_BANCOMER_TB, MX_BANCOMER_DR, MX_BANAMEX_TD, MX_AMEX, MX_SEVEN_ELEVEN
}PaymentMethodMx;

extern NSString* PAYMENTMETHODMX[23];
extern NSString* PAYMENTMETHODCL[10];
extern NSString* PAYMENTMETHODBR[12];
extern NSString* PAYMENTMETHODAR[14];

#endif