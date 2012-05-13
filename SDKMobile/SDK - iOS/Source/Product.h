//
//  Product.h
//  PostWebView
//
//  Created on 9/8/11.
//  Copyright 2011 DineroMail. All rights reserved.
//
#ifndef		__PRODUCT_H__
#define		__PRODUCT_H__

#import <Foundation/Foundation.h>
#import	"Enums.h"

@interface Product : NSObject {
	NSString*	name;
	NSString*	code;
	int			quantity;
	float		amount;
	NSString*	currency;
	NSString*		weight;
	float		weightValue;
	
	float		shippingCostDefault;
	float		shippingCostTwo;
	
	NSInteger	shippingType;
	NSString*		shippingCurrency;
	
	NSString*	additionalVarDescription;
	NSString*	additionalVarValue;
	NSInteger	additionalVarVisible;
	bool		additionalVarRequired;
}

@property(nonatomic, retain) NSString*	name;
@property(nonatomic, retain) NSString*	code;
@property(nonatomic, assign) int		quantity;
@property(nonatomic, assign) float		amount;
@property(nonatomic, retain) NSString*	currency;
@property(nonatomic, retain) NSString*	weight;
@property(nonatomic, assign) float		weightValue;

@property(nonatomic, assign) float		shippingCostDefault;
@property(nonatomic, assign) float		shippingCostTwo;

@property(nonatomic, assign) NSInteger	shippingType;
@property(nonatomic, assign) NSString*		shippingCurrency;

@property(nonatomic, retain) NSString*	additionalVarDescription;
@property(nonatomic, retain) NSString*	additionalVarValue;
@property(nonatomic, assign) NSInteger	additionalVarVisible;
@property(nonatomic, assign) bool		additionalVarRequired;

- (bool) isEqual:(id)object;
- (bool) isValid;

@end

#endif