//
//  RootViewController.m
//  PostWebView
//
//  Created on 9/7/11.
//  Copyright 2011 DineroMail. All rights reserved.
//

#import "MainViewController.h"
#import "DineroMailAr.h"
#import "DineroMailMx.h"
#import "WebViewContoller.h"

@implementation MainViewController
@synthesize mTitle, mWebViewTitle;

#pragma mark -
#pragma mark View lifecycle

- (id) initWithTitle:(NSString*) sTitle webViewTitle:(NSString*) sWebViewTitle
{
	self = [super init];
	if (self) {
		self.mTitle = sTitle;
		self.mWebViewTitle = sWebViewTitle;
		self.title = self.mTitle;
	}
	return self;
}

- (void)viewDidLoad {
    [super viewDidLoad];		
	self.view.backgroundColor = [UIColor blackColor];
	NSLog(@"%@,%d", BUYERCOUNTRY[ARGENTINA], ARGENTINA);
	
	button1 = [UIButton buttonWithType: UIButtonTypeRoundedRect];
	[button1 setTitle: @"Example1" forState: UIControlStateNormal];
	[button1 addTarget:self action: @selector(onButtonOne:) forControlEvents: UIControlEventTouchUpInside];
	[self.view addSubview: button1];
	
	button2 = [UIButton buttonWithType: UIButtonTypeRoundedRect];
	[button2 setTitle: @"Example2" forState: UIControlStateNormal];
	[button2 addTarget:self action: @selector(onButtonTwo:) forControlEvents: UIControlEventTouchUpInside];
	[self.view addSubview: button2];
	[self relayout];
    // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
    // self.navigationItem.rightBarButtonItem = self.editButtonItem;
}


- (void)viewWillAppear:(BOOL)animated {
	self.title = self.mTitle;
    [super viewWillAppear:animated];
	[self relayout];
}

/*
- (void)viewDidAppear:(BOOL)animated {
    [super viewDidAppear:animated];
}
*/
/*
- (void)viewWillDisappear:(BOOL)animated {
	[super viewWillDisappear:animated];
}
*/
/*
- (void)viewDidDisappear:(BOOL)animated {
	[super viewDidDisappear:animated];
}
*/

- (void) relayout
{
	CGSize size = self.view.frame.size;
	CGSize btnSize = CGSizeMake(100,30);
	
	float xPos = (size.width - btnSize.width)/2;
	button1.frame = CGRectMake(xPos, size.height*0.3, btnSize.width, btnSize.height);
	button2.frame = CGRectMake(xPos, size.height*0.6, btnSize.width, btnSize.height);
}

 // Override to allow orientations other than the default portrait orientation.
- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation {
	// Return YES for supported orientations.
	return YES;
	//return (interfaceOrientation == UIInterfaceOrientationPortrait);
}

- (void)didRotateFromInterfaceOrientation:(UIInterfaceOrientation)fromInterfaceOrientation
{
	[self relayout];
}

- (void) showWebView :(DineroMail*) param
{
	self.navigationItem.backBarButtonItem = [[[UIBarButtonItem alloc] initWithTitle:@"Cancel"
																			  style:UIBarButtonItemStyleBordered                     
																			 target:nil action:nil] autorelease]; 
	
	WebViewContoller* pController = [[WebViewContoller alloc] initWithDinero: param withTitle: self.mWebViewTitle];
	[self.navigationController pushViewController: pController animated: YES];
	[pController release];
}

-(void) onButtonOne : (id) sender
{
	DineroMailAr* exOne = [DineroMailAr new];
	exOne.tool = TOOL[BUTTON];
	exOne.merchant = @"dmoperator0001@hotmail.com";
	exOne.sellerName = @"sellerName C1";
	
	exOne.products = [[NSMutableArray alloc] init];
	Product * p = [Product new];
	[p setName :@"Camera Panasonic Lumix Fz35 12.1Mp"];
	[p setQuantity :1];
	[p setAmount :10000];
	[p setCurrency :CURRENCY[ARS]];
	[p setShippingType : ST_NOT_AVAILABLE];
	[p setShippingCurrency :CURRENCY[ARS]];
	[exOne.products addObject: p];
	[p release];

	[exOne addPaymentMethod: PAYMENTMETHODAR[AR_ALL]];
	[exOne setLanguage: LANGUAGE[EN]];
	[exOne setChangeQuantity: NO_MODIFICATION_ALLOWED];
	
	if ([exOne validateMandatoryFields]) {
		[self showWebView: exOne];	
	}
//	[exOne release];
}

-(void) onButtonTwo : (id) sender
{
	DineroMailMx* exOne = [DineroMailMx new];
	exOne.tool = TOOL[BUTTON];
	exOne.merchant = @"dmoperator0001@hotmail.com";
	exOne.sellerName = @"sellerName C2";
	
	exOne.products = [[NSMutableArray alloc] init];
	Product * p = [Product new];
	[p setName :@"Camera Panasonic Lumix Fz35 12.1Mp"];
	[p setQuantity :1];
	[p setAmount :10000];
	[p setCurrency :CURRENCY[MXN]];
	[p setShippingType : ST_FIXED_COST];
	[p setShippingCurrency :CURRENCY[MXN]];
	[p setShippingCostDefault: 1];
	[exOne.products addObject: p];
	[p release];
	
	[exOne addPaymentMethod: PAYMENTMETHODMX[MX_OXXO]];
	[exOne setPaymentMethodDefault: PAYMENTMETHODMX[MX_OXXO]];
	[exOne setLanguage: LANGUAGE[EN]];
	[exOne setChangeQuantity:  NO_MODIFICATION_ALLOWED];
	
	[exOne setOkUrl: @"http://www.hotmail.com"];
	[exOne setErrorUrl: @"http://www.gmail.com"];
	[exOne setPendingUrl: @"http://www.yahoo.com"];
	
	[exOne setBuyerName: @"Nombre"];
	[exOne setBuyerLastName: @"Apellido"];
	[exOne setBuyerSex: SEX[MALE]];
	[exOne setBuyerNationality: BUYERCOUNTRY[ARGENTINA]];
	[exOne setBuyerDocumentType: DOCUMENTTYPE[DNI]];
	[exOne setBuyerDocumentNumber: @"12345678"];
	[exOne setBuyerEmail: @"test@test.com"];
	[exOne setBuyerPhone: @"55555555"];
	[exOne setBuyerPhoneExtension:@"123"];
	[exOne setBuyerZipCode: @"1234"];
	[exOne setBuyerStreet: @"buyer_street"];
	[exOne setBuyerNumber: @"123"];
	[exOne setBuyerComplement: @"buyer_complement"];
	[exOne setBuyerCity: @"buyer_city"];
	[exOne setBuyerState: @"buyer_state"];
	[exOne setBuyerCountry: BUYERCOUNTRY[ARGENTINA]];
	 
	if ([exOne validateMandatoryFields]) {
		[self showWebView: exOne];	
	}
//	[exOne release];
}

#pragma mark -
#pragma mark Memory management

- (void)didReceiveMemoryWarning {
    // Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];
    
    // Relinquish ownership any cached data, images, etc that aren't in use.
}

- (void)viewDidUnload {
    // Relinquish ownership of anything that can be recreated in viewDidLoad or on demand.
    // For example: self.myOutlet = nil;
}


- (void)dealloc {
    [super dealloc];
}


@end

