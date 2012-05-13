//
//  DineroMailMx.m
//  PostWebView
//
//  Created on 9/9/11.
//  Copyright 2011 DineroMail. All rights reserved.
//

#import "DineroMailMx.h"


@implementation DineroMailMx

-(id) init
{
	self = [super init];
	if (self) {
		self.country = MEXICO;
		[self setCurrency: CURRENCY[MXN]];
		self.language = LANGUAGE[ES];
	}
	return self;
}
@end
