//
//  Payment.m
//  PostWebView
//
//  Created on 9/9/11.
//  Copyright 2011 DineroMail. All rights reserved.
//

#import "Payment.h"


@implementation Payment
@synthesize paymentMethod, installments;

-(id) initWithPaymentMethod:(NSString*) pm withInstallment:(NSMutableArray*) insts
{
	self = [super init];
	if (self) {
		self.paymentMethod = pm;
		self.installments = insts;
	}
	return self;
}
@end
