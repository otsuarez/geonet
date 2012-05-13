//
//  DineroMailCl.m
//  PostWebView
//
//  Created on 9/9/11.
//  Copyright 2011 DineroMail. All rights reserved.
//
	
#import "DineroMailCl.h"


@implementation DineroMailCl

-(id) init
{
	self = [super init];
	if (self) {
		self.country = CHILE;
		[self setCurrency: CURRENCY[CLP]];
		self.language = LANGUAGE[ES];
	}
	return self;
}
@end
