//
//  DineroMailBr.m
//  PostWebView
//
//  Created on 9/9/11.
//  Copyright 2011 DineroMail. All rights reserved.
//

#import "DineroMailBr.h"


@implementation DineroMailBr

-(id) init
{
	self = [super init];
	if (self) {
		self.country = BRAZIL;
		[self setCurrency: CURRENCY[BRL]];
		self.language = LANGUAGE[PT];
	}
	return self;
}
@end
