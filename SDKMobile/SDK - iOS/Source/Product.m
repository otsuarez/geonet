//
//  Product.m
//  PostWebView
//
//  Created on 9/8/11.
//  Copyright 2011 DineroMail. All rights reserved.
//

#import "Product.h"


@implementation Product
@synthesize name,code,quantity,amount,currency,weight,weightValue;
@synthesize shippingCostDefault,shippingCostTwo;
@synthesize shippingType,shippingCurrency;
@synthesize additionalVarDescription,additionalVarValue,additionalVarVisible,additionalVarRequired;

- (id) init
{
	self = [super init];
	if (self) {
		self.shippingType = -1;
		self.additionalVarVisible = -1;
	}
	return self;
}
- (bool) isEqual:(id)object
{
	Product* other = (Product*) object;
	if ([self.name isEqualToString: other.name]) {
		return true;
	}
	return false;
}

- (bool) isValid
{
	if (!self.name || self.name.length == 0) {
		return false;
	}
	
	if (self.quantity <= 0) {
		return false;
	}
	
	if (self.amount <= 0) {
		return false;
	}
	return true;
}

@end
