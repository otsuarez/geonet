//
//  DineroMail.m
//  PostWebView
//
//  Created on 9/8/11.
//  Copyright 2011 DineroMail. All rights reserved.
//

#import "DineroMail.h"

@implementation DineroMail

@synthesize tool, merchant, country, sellerName, language, transactionId, okUrl, errorUrl, pendingUrl, urlRedirectEnabled,buyerMessage,changeQuantity,displayShipping,displayAdditionalCharge, currency;
@synthesize buyerName,buyerLastName, buyerSex, buyerNationality, buyerDocumentNumber, buyerEmail, buyerPhone, buyerPhoneExtension,buyerZipCode,buyerStreet,buyerNumber,buyerComplement,buyerCity,buyerState,buyerCountry,buyerDocumentType;
@synthesize additionalFixedCharge, additionalFixedChargeCurrency, additionalVariableCharge;
@synthesize headerImage, headerWidth, expandedStepPM, expandedStepAD, expandedStepSC, expandedSaleDetail;
@synthesize stepColor, hoverStepColor, linksColor, fontColor, borderColor, buttonColor, buttonImage;
@synthesize headerVisible, summaryVisible, products, paymentMethodDefault, paymentMethodsAvailable;

-(id) init
{
	self = [super init];
	if (self) {
		self.headerWidth = -1;
		self.expandedStepAD = -1;
		self.expandedStepPM = -1;
		self.expandedStepSC = -1;
		self.expandedSaleDetail = -1;
		self.currency = @"";
		self.paymentMethodDefault = @"";
		self.changeQuantity = -1;
	}
	return self;
}

-(NSMutableDictionary*)	getParams
{
	NSMutableDictionary* map = [[NSMutableDictionary alloc] init];
	if (self.tool != nil) {
		[map setObject: self.tool forKey: @"tool"];
	}
	[map setObject: self.merchant forKey: @"merchant"];
	[map setObject: [NSString stringWithFormat:@"%d",self.country] forKey:@"country_id"];
	
	if (self.sellerName.length != 0) {
		[map setObject: self.sellerName forKey: @"seller_name"];
	}
	
	if (self.language) {
		[map setObject: self.language forKey:@"language"];
	}
	
	if (self.transactionId != 0) {
		[map setObject:[NSString stringWithFormat:@"%d", self.transactionId] forKey: @"transaction_id"];
	}
	
	[map setObject: self.currency forKey: @"currency"];
	
	if (self.okUrl.length != 0) {
		[map setObject: self.okUrl forKey: @"ok_url"];
	}
	
	if (self.errorUrl.length != 0) {
		[map setObject: self.errorUrl forKey: @"error_url"];
	}
	
	if (self.pendingUrl.length != 0) {
		[map setObject: self.pendingUrl forKey: @"pending_url"];
	}
	
	if (self.buyerMessage) {
		[map setObject: self.buyerMessage forKey: @"buyer_message"];
	}
	
	if (self.changeQuantity != -1) {
		[map setObject: [NSString stringWithFormat:@"%d",self.changeQuantity] forKey: @"change_quantity"];
	}
	
	if (self.displayShipping) {
		[map setObject: self.displayShipping forKey: @"display_shipping"];
	}
	
	if (self.displayAdditionalCharge) {
		[map setObject: self.displayAdditionalCharge forKey: @"display_additional_charge"];
	}
	
	NSString* strPayment = [self getPaymentMethodAsString];
	[map setObject: strPayment forKey:@"payment_method_available"];
	[map setObject: self.paymentMethodDefault forKey:@"payment_method_1"];	
	
	int i = 1;
	for ( Product* product in self.products) {
		NSString* key = [@"item_name_" stringByAppendingFormat:@"%d", i];
		[map setObject: product.name forKey: key];
		
		if ( product.code.length != 0 )
		{
			key = [@"item_code_" stringByAppendingFormat:@"%d", i];
			[map setObject: product.code forKey: key];
		}
		
		key = [@"item_quantity_" stringByAppendingFormat:@"%d", i];
		[map setObject: [NSString stringWithFormat:@"%d",product.quantity] forKey: key];

		key = [@"item_ammount_" stringByAppendingFormat:@"%d", i];
		[map setObject: [NSString stringWithFormat:@"%.2f",product.amount] forKey: key];
		
		if ( product.currency.length != 0 )
		{
			key = [@"item_currency_" stringByAppendingFormat:@"%d", i];
			[map setObject: product.currency forKey: key];
		}
		
		if ( product.shippingType != -1) {
			key = [@"shipping_type_" stringByAppendingFormat:@"%d", i];
			[map setObject: [NSString stringWithFormat:@"%d", product.shippingType] forKey: key];
		}
		
		if ( product.weight != nil) {
			key = [@"weight_" stringByAppendingFormat:@"%d", i];
			[map setObject: product.weight forKey: key];
		}
		
		if ( product.weightValue != 0) {
			key = [@"item_weight_" stringByAppendingFormat:@"%d", i];
			[map setObject: [NSString stringWithFormat:@"%f", product.weightValue] forKey: key];
		}
		
		if ( product.shippingCurrency != nil) {
			key = [@"shipping_currency_" stringByAppendingFormat:@"%d", i];
			[map setObject: product.shippingCurrency forKey: key];
		}
		
		if ( product.shippingCostDefault != 0) {
			key = [@"shipping_cost_1_" stringByAppendingFormat:@"%d", i];
			[map setObject: [NSString stringWithFormat:@"%f", product.shippingCostDefault] forKey: key];
		}
		
		if ( product.shippingCostTwo != 0) {
			key = [@"shipping_cost_2_" stringByAppendingFormat:@"%d", i];
			[map setObject: [NSString stringWithFormat:@"%f", product.shippingCostTwo] forKey: key];
		}
		
		if ( product.additionalVarDescription != nil) {
			key = [@"additional_var_description_" stringByAppendingFormat:@"%d", i];
			[map setObject: product.additionalVarDescription forKey: key];
		}

		if ( product.additionalVarValue != nil) {
			key = [@"additional_var_value_" stringByAppendingFormat:@"%d", i];
			[map setObject: product.additionalVarValue forKey: key];
		}
		
		if ( product.additionalVarVisible != -1) {
			key = [@"additional_var_visible_" stringByAppendingFormat:@"%d", i];
			[map setObject: [NSString stringWithFormat:@"%d", product.additionalVarVisible] forKey: key];
		}
		
		key = [@"additional_var_required_" stringByAppendingFormat:@"%d", i];
		[map setObject: [NSString stringWithFormat:@"%d", product.additionalVarRequired] forKey: key];
		i++;
	}

//Buyer var
		if (self.buyerName.length != 0)
			[map setObject:@"buyer_name" forKey: self.buyerName];
		if (self.buyerLastName.length != 0)
			[map setObject:@"buyer_lastname" forKey: self.buyerLastName];
		if (self.buyerSex != nil)
			[map setObject:@"buyer_sex" forKey: self.buyerSex];
		if (self.buyerNationality != nil)
			[map setObject:@"buyer_nationallity" forKey: self.buyerNationality];
		if (self.buyerDocumentType.length != 0)
			[map setObject:@"buyer_document_type" forKey: self.buyerDocumentType];
		if (self.buyerDocumentNumber.length != 0)
			[map setObject:@"buyer_document_number" forKey: self.buyerDocumentNumber];
		if (self.buyerEmail.length != 0)
			[map setObject:@"buyer_email" forKey: self.buyerEmail];
		if (self.buyerPhone.length != 0)
			[map setObject:@"buyer_phone" forKey: self.buyerPhone];
		if (self.buyerPhoneExtension.length != 0)
			[map setObject:@"buyer_phone_extension" forKey: self.buyerPhoneExtension];
		if (self.buyerZipCode.length != 0)
			[map setObject:@"buyer_zip_code" forKey: self.buyerZipCode];
		if (self.buyerStreet.length != 0)
			[map setObject:@"buyer_street" forKey: self.buyerStreet];
		if (self.buyerNumber.length != 0)
			[map setObject:@"buyer_number" forKey: self.buyerNumber];
		if (self.buyerComplement.length != 0)
			[map setObject:@"buyer_complent" forKey: self.buyerComplement];
		if (self.buyerCity.length != 0)
			[map setObject:@"buyer_city" forKey: self.buyerCity];
		if (self.buyerState.length != 0)
			[map setObject:@"buyer_state" forKey: self.buyerState];
		if (self.buyerCountry.length != 0)
			[map setObject:@"buyer_country" forKey: self.buyerCountry];
//Additional Vars
		if (self.additionalFixedCharge != 0)
			[map setObject: [NSString stringWithFormat:@"%f", self.additionalFixedCharge] forKey: @"additional_fixed_charge"];
		if (self.additionalVariableCharge != 0)
			[map setObject: [NSString stringWithFormat:@"%f", self.additionalVariableCharge] forKey: @"additional_variable_charge"];
		if (self.additionalFixedChargeCurrency.length != 0) 
			[map setObject: self.additionalFixedChargeCurrency forKey:@"additional_fixed_charge_currency"];
		
//Design Variables
		if (self.headerImage.length != 0) 
			[map setObject: self.headerImage forKey:@"header_images"];
		if (self.headerWidth != -1) 
			[map setObject: [NSString stringWithFormat:@"%d", self.headerWidth] forKey:@"header_width"];
		if (self.expandedStepPM != -1) 
			[map setObject: [NSString stringWithFormat:@"%d", self.expandedStepAD] forKey:@"expanded_step_PM"];
		if (self.expandedStepSC != -1) 
			[map setObject: [NSString stringWithFormat:@"%d", self.expandedStepSC] forKey:@"expanded_step_SC"];
		if (self.expandedStepAD != -1) 
			[map setObject: [NSString stringWithFormat:@"%d", self.headerWidth] forKey:@"expanded_step_AD"];
		if (self.expandedSaleDetail != -1) 
			[map setObject: [NSString stringWithFormat:@"%d", self.headerWidth] forKey:@"expanded_sale_detail"];
	
		if (self.stepColor.length != 0) 
			[map setObject: self.stepColor forKey:@"step_color"];
		if (self.hoverStepColor.length != 0) 
			[map setObject: self.hoverStepColor forKey:@"hover_step_color"];
		if (self.linksColor.length != 0) 
			[map setObject: self.linksColor forKey:@"links_color"];
		if (self.fontColor.length != 0) 
			[map setObject: self.fontColor forKey:@"font_color"];
		if (self.borderColor.length != 0) 
			[map setObject: self.borderColor forKey:@"border_color"];
		if (self.buttonColor.length != 0) 
			[map setObject: self.buttonColor forKey:@"button_color"];
		
	return map;
}

-(NSString*) getPaymentMethodAsString
{
	NSString *methods = @"";
	int j=0;
	for (Payment* payment in self.paymentMethodsAvailable)
	{
		NSString* paymentMethod = payment.paymentMethod;
		methods = [methods stringByAppendingString: paymentMethod];
		
		if (payment.installments) {
			int nCount = [payment.installments count];
			for (int i = 0; i<nCount;i++) 
			{
				methods = [methods stringByAppendingString:@","];
				int val = [(NSNumber*)[payment.installments objectAtIndex: i] intValue];
				
				if (i == nCount - 1) {
					methods = [methods stringByAppendingFormat:@"%d", val];
				}
				else {
					methods = [methods stringByAppendingFormat:@"%d,", val];
				}
			}
		}
		if ( j != [self.paymentMethodsAvailable count] - 1) {
			methods = [methods stringByAppendingString:@";"];
		}
		
		j++;
	}
	return methods;
}

- (void) addPaymentMethod:(NSString*) paymentmethod : (NSMutableArray*) installments
{
	Payment* payment = [[Payment alloc] initWithPaymentMethod: paymentmethod withInstallment: installments];
	if (self.paymentMethodsAvailable == nil) {
		self.paymentMethodsAvailable = [[NSMutableArray alloc] init];
	}
	[self.paymentMethodsAvailable addObject: payment];
	[payment release];
}

- (void) addPaymentMethod:(NSString*) paymentmethod
{
	[self addPaymentMethod: paymentmethod : nil];
}

- (bool) validateMandatoryFields
{
	if ( self.merchant == nil || self.merchant.length ==0) {
		return false;
	}
	
	if ([self.paymentMethodsAvailable count] == 0) {
		return false;
	}
	
	for (Product* product in self.products) {
		if (![product isValid]) {
			return false;
		}
	}
	return true;
}

-(void) dealloc{
	[self.paymentMethodsAvailable release];
	[super dealloc];
}
@end
