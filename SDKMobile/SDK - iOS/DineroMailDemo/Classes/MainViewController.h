//
//  RootViewController.h
//  PostWebView
//
//  Created on 9/7/11.
//  Copyright 2011 DineroMail. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface MainViewController : UIViewController {
	UIButton*	button1;
	UIButton*	button2;
	NSString*	mTitle;
	NSString*	mWebViewTitle;
}

@property( nonatomic, retain) NSString* mTitle;
@property( nonatomic, retain) NSString* mWebViewTitle;

- (id) initWithTitle:(NSString*) sTitle webViewTitle:(NSString*) sWebViewTitle;
-(void) onButtonOne : (id) sender;
-(void) onButtonTwo : (id) sender;
- (void) relayout;
@end
