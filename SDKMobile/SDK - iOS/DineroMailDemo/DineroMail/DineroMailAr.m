//
//  DineroMailAr.m
//  PostWebView
//
//  Created on 9/9/11.
//  Copyright 2011 DineroMail. All rights reserved.
//

#import "DineroMailAr.h"


@implementation DineroMailAr

-(id) init
{
	self = [super init];
	if (self) {
		self.country = ARGENTINA;
		[self setCurrency: CURRENCY[ARS]];
		self.language = LANGUAGE[ES];
	}
	return self;
}

@end
