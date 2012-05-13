//
//  Payment.h
//  PostWebView
//
//  Created on 9/9/11.
//  Copyright 2011 DineroMail. All rights reserved.
//
#ifndef		__PAYMENT_H__
#define		__PAYMENT_H__

#import <Foundation/Foundation.h>


@interface Payment : NSObject {
	NSString*			paymentMethod;
	NSMutableArray*		installments;
}

@property(nonatomic, retain) NSString* paymentMethod;
@property(nonatomic, retain) NSMutableArray* installments;

-(id) initWithPaymentMethod:(NSString*) pm withInstallment:(NSMutableArray*) insts;

@end

#endif