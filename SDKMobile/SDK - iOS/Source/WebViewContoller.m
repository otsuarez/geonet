//
//  WebViewContoller.m
//  GascoigneHalman
//
//  Created by Ivan on 7/9/10.
//  Copyright 2010 DineroMail. All rights reserved.
//

#import "WebViewContoller.h"
#import "HTTPRequest.h"

@implementation WebViewContoller
@synthesize mDinero, mTitle;

- (void) dealloc
{
	[mWebView stopLoading];
	mWebView.delegate = nil;
	[mWebView removeFromSuperview];
	mWebView = nil;
 	[super dealloc];
}

- (id) initWithDinero: (DineroMail*) set withTitle:(NSString*) sTitle
{
	self = [super init];
	if (self) {
		mActivityView = [[UIActivityIndicatorView alloc] initWithActivityIndicatorStyle: UIActivityIndicatorViewStyleGray];
		mActivityView.frame = CGRectMake(145, 200, 30, 30);
		mActivityView.hidesWhenStopped = YES;
		mActivityView.hidden = YES;
		self.mTitle = sTitle;
		self.mDinero = set;
	}
	return self;
}

- (void)viewWillAppear:(BOOL)animated {
//	self.title = self.mTitle;
//	self.navigationItem.backBarButtonItem = [[[UIBarButtonItem alloc] initWithTitle:@"Cancel"
//																			   style:UIBarButtonItemStyleBordered                     
//																			  target:nil action:nil] autorelease]; 
//	[super viewWillAppear:animated]; 
    
	[self relayout];
}

-(void) viewDidLoad
{	
//	self.navigationItem.backBarButtonItem = [[[UIBarButtonItem alloc] initWithTitle:@"Cancel"
//																			  style:UIBarButtonItemStyleBordered                     
//																			 target:nil action:nil] autorelease]; 
	
	self.navigationController.navigationBar.tintColor = [UIColor blackColor];
	self.navigationController.navigationBarHidden = NO;
	[UIApplication sharedApplication].networkActivityIndicatorVisible = YES;
	
	mWebView = [[UIWebView alloc] initWithFrame:CGRectMake(0, 0, 320, 430)];
	mWebView.scalesPageToFit = YES;
	mWebView.multipleTouchEnabled = YES;
	mWebView.delegate = self;
	self.view.autoresizesSubviews = YES;
	[self.view addSubview:mWebView];
	[mWebView release];
	
	[self.view addSubview: mActivityView];
	[mActivityView startAnimating];
	mActivityView.hidden = NO;
	
	[self relayout];
	[self performSelectorOnMainThread:@selector(loadRequest) withObject:nil waitUntilDone: NO];
}

-(void) loadRequest
{
	HTTPRequest *httpRequest = [[HTTPRequest alloc] init]; 
    NSDictionary *bodyObject = [mDinero getParams];
    [httpRequest setDelegate:self selector:@selector(didReceiveFinished:)]; 
	
	NSMutableURLRequest* request = [httpRequest requestUrl:CHECKOUT_URL bodyObject:bodyObject]; 
    [request setHTTPShouldHandleCookies :YES];
	[mWebView loadRequest: request];
	[httpRequest release];
}

- (void) didReceiveFinished:(id) sender
{
	
}

- (void) viewWillDisappear
{
	[UIApplication sharedApplication].networkActivityIndicatorVisible = NO;
	[mWebView stopLoading];
	[mWebView loadHTMLString:@"" baseURL:nil];
	[self.mDinero release];
}

- (void) webViewDidFinishLoad:(UIWebView *)webView
{
	[UIApplication sharedApplication].networkActivityIndicatorVisible = NO;
	[mWebView stopLoading];
	[mActivityView stopAnimating];
	mActivityView.hidden = YES;
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation {
	// Return YES for supported orientations.
	return YES;
	//return (interfaceOrientation == UIInterfaceOrientationPortrait);
}

- (void) relayout
{
	CGSize size = self.view.frame.size;
	mActivityView.frame = CGRectMake((size.width-30)/2, (size.height-30)/2, 30, 30);
	mWebView.frame = self.view.frame;
}

- (void)didRotateFromInterfaceOrientation:(UIInterfaceOrientation)fromInterfaceOrientation
{
	[self relayout];
	//[mWebView reload];
}


@end
