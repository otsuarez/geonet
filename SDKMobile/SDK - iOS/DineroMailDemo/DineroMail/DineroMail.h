//
//  DineroMail.h
//  PostWebView
//
//  Created on 9/8/11.
//  Copyright 2011 DineroMail. All rights reserved.
//
#ifndef	__DINEROMAIL_H__
#define	__DINEROMAIL_H__

#import <Foundation/Foundation.h> 
#import "Enums.h"
#import "Payment.h"
#import "Product.h"

@interface DineroMail : NSObject {
	NSString*	tool;
	NSString*	merchant;
	Country		country;
	NSString*	sellerName;
	NSString*	language;
	long		transactionId;
	NSString*	okUrl;
	NSString*	errorUrl;
	NSString*	pendingUrl;
	bool		urlRedirectEnabled;
	NSString*	buyerMessage;
	NSInteger	changeQuantity;
	NSString*	displayShipping;
	NSString*	displayAdditionalCharge;
	NSString*	currency;
	
	NSString*	buyerName;
	NSString*	buyerLastName;
	NSString*	buyerSex;
	NSString*	buyerNationality;
	NSString*	buyerDocumentNumber;
	NSString*	buyerEmail;
	NSString*	buyerPhone;
	NSString*	buyerPhoneExtension;
	NSString*	buyerZipCode;
	NSString*	buyerStreet;
	NSString*	buyerNumber;
	NSString*	buyerComplement;
	NSString*	buyerCity;
	NSString*	buyerState;
	NSString*	buyerCountry;
	NSString*	buyerDocumentType;

	float		additionalFixedCharge;
	NSString*	additionalFixedChargeCurrency;
	float		additionalVariableCharge;
	
	NSString*	headerImage;
	NSInteger	headerWidth;
	NSInteger	expandedStepPM;
	NSInteger	expandedStepAD;
	NSInteger	expandedStepSC;
	NSInteger	expandedSaleDetail;
	
	NSString*	stepColor;
	NSString*	hoverStepColor;
	NSString*	linksColor;
	NSString*	fontColor;
	NSString*	borderColor;
	NSString*	buttonColor;
	NSString*	buttonImage;
	
	bool		headerVisible;
	bool		summaryVisible;
	
	NSString*	paymentMethodDefault;
	NSMutableArray*		paymentMethodsAvailable;
	NSMutableArray*		products;
}

@property(nonatomic, retain) NSString*	tool;
@property(nonatomic, retain) NSString*	merchant;
@property(nonatomic, assign) Country	country;
@property(nonatomic, retain) NSString*	sellerName;
@property(nonatomic, retain) NSString*	language;
@property(nonatomic, assign) long		transactionId;
@property(nonatomic, retain) NSString*	okUrl;
@property(nonatomic, retain) NSString*	errorUrl;
@property(nonatomic, retain) NSString*	pendingUrl;
@property(nonatomic, assign) bool		urlRedirectEnabled;
@property(nonatomic, retain) NSString*	buyerMessage;
@property(nonatomic, assign) NSInteger	changeQuantity;
@property(nonatomic, retain) NSString*	displayShipping;
@property(nonatomic, retain) NSString*	displayAdditionalCharge;
@property(nonatomic, retain) NSString*	currency;

@property(nonatomic, retain) NSString*	buyerName;
@property(nonatomic, retain) NSString*	buyerLastName;
@property(nonatomic, retain) NSString*	buyerSex;
@property(nonatomic, retain) NSString*	buyerNationality;
@property(nonatomic, retain) NSString*	buyerDocumentNumber;
@property(nonatomic, retain) NSString*	buyerEmail;
@property(nonatomic, retain) NSString*	buyerPhone;
@property(nonatomic, retain) NSString*	buyerPhoneExtension;
@property(nonatomic, retain) NSString*	buyerZipCode;
@property(nonatomic, retain) NSString*	buyerStreet;
@property(nonatomic, retain) NSString*	buyerNumber;
@property(nonatomic, retain) NSString*	buyerComplement;
@property(nonatomic, retain) NSString*	buyerCity;
@property(nonatomic, retain) NSString*	buyerState;
@property(nonatomic, retain) NSString*	buyerCountry;
@property(nonatomic, retain) NSString*	buyerDocumentType;

@property(nonatomic, assign) float		additionalFixedCharge;
@property(nonatomic, retain) NSString*	additionalFixedChargeCurrency;
@property(nonatomic, assign) float		additionalVariableCharge;

@property(nonatomic, retain) NSString*	headerImage;
@property(nonatomic, assign) NSInteger	headerWidth;
@property(nonatomic, assign) NSInteger	expandedStepPM;
@property(nonatomic, assign) NSInteger	expandedStepAD;
@property(nonatomic, assign) NSInteger	expandedStepSC;
@property(nonatomic, assign) NSInteger	expandedSaleDetail;

@property(nonatomic, retain) NSString*	stepColor;
@property(nonatomic, retain) NSString*	hoverStepColor;
@property(nonatomic, retain) NSString*	linksColor;
@property(nonatomic, retain) NSString*	fontColor;
@property(nonatomic, retain) NSString*	borderColor;
@property(nonatomic, retain) NSString*	buttonColor;
@property(nonatomic, retain) NSString*	buttonImage;

@property(nonatomic, assign) bool headerVisible;
@property(nonatomic, assign) bool summaryVisible;

@property(nonatomic, retain) NSMutableArray*		paymentMethodsAvailable;
@property(nonatomic, retain) NSMutableArray*		products;
@property(nonatomic, retain) NSString*				paymentMethodDefault;

-(NSMutableDictionary*)	getParams;
-(NSString*) getPaymentMethodAsString;
- (void) addPaymentMethod:(NSString*) paymentmethod : (NSMutableArray*) installments;
- (void) addPaymentMethod:(NSString*) paymentmethod;
- (bool) validateMandatoryFields;

@end

#endif