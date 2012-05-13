//
//  WebViewContoller.h
//  GascoigneHalman
//
//  Created by Ivan on 7/9/10.
//  Copyright 2010 DineroMail. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "DineroMail.h"

@interface WebViewContoller : UIViewController <UIWebViewDelegate>
{
	UIWebView *mWebView;
	DineroMail*	mDinero;
	UIActivityIndicatorView*	mActivityView;
	NSString* mTitle;
}
@property (nonatomic, retain) DineroMail* mDinero;
@property (nonatomic, retain) NSString* mTitle;

- (id) initWithDinero: (DineroMail*) set withTitle:(NSString*) sTitle;
- (void) relayout;
@end
