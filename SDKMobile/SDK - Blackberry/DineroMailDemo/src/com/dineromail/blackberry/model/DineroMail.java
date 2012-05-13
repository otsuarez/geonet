package com.dineromail.blackberry.model;

import com.dineromail.blackberry.enums.AdditionalChargeDisplay;
import com.dineromail.blackberry.enums.BuyerCountry;
import com.dineromail.blackberry.enums.BuyerMessage;
import com.dineromail.blackberry.enums.ChangeQuantity;
import com.dineromail.blackberry.enums.Country;
import com.dineromail.blackberry.enums.Currency;
import com.dineromail.blackberry.enums.DocumentType;
import com.dineromail.blackberry.enums.Language;
import com.dineromail.blackberry.enums.Sex;
import com.dineromail.blackberry.enums.ShippingDisplay;
import com.dineromail.blackberry.enums.Tool;
import com.dineromail.blackberry.enums.design.ExpandedSaleDetail;
import com.dineromail.blackberry.enums.design.ExpandedStepAD;
import com.dineromail.blackberry.enums.design.ExpandedStepPM;
import com.dineromail.blackberry.enums.design.ExpandedStepSC;
import com.dineromail.blackberry.enums.design.HeaderWidth;
import com.dineromail.blackberry.utils.StringUtils;

public abstract class DineroMail {

	// Salesment variables
	protected Tool tool;
	protected String merchant;
	protected Country country;
	protected String sellerName;
	protected Language language;
	protected long transactionId;
	protected String okUrl;
	protected String errorUrl;
	protected String pendingUrl;
	protected boolean urlRedirectEnabled;
	protected BuyerMessage buyerMessage;
	protected ChangeQuantity changeQuantity;
	protected ShippingDisplay displayShipping;
	protected AdditionalChargeDisplay displayAdditionalCharge;

	// Buyer variables
	protected String buyerName;
	protected String buyerLastName;
	protected Sex buyerSex;
	protected BuyerCountry buyerNationality;
	protected String buyerDocumentNumber;
	protected String buyerEmail;
	protected String buyerPhone;
	protected String buyerPhoneExtension;
	protected String buyerZipCode;
	protected String buyerStreet;
	protected String buyerNumber;
	protected String buyerComplement;
	protected String buyerCity;
	protected String buyerState;
	protected BuyerCountry buyerCountry;
	protected DocumentType buyerDocumentType;

	// Aditional variables
	protected float additionalFixedCharge;
	protected Currency additionalFixedChargeCurrency;
	protected float additionalVariableCharge;

	// Design variables
	protected String headerImage;
	protected HeaderWidth headerWidth;
	protected ExpandedStepPM expandedStepPM;
	protected ExpandedStepAD expandedStepAD;
	protected ExpandedStepSC expandedStepSC;
	protected ExpandedSaleDetail expandedSaleDetail;
	protected String stepColor;
	protected String hoverStepColor;
	protected String linksColor;
	protected String fontColor;
	protected String borderColor;
	protected String buttonColor;
	protected String buttonImage;
	protected boolean headerVisible;
	protected boolean summaryVisible;

	// Product/Item variables
	protected Product[] products;
	public static final String FORM_PARAM = "formParam";

	public Product[] getProducts() {
		return products;
	}

	/**
	 * List of Products/Items
	 * 
	 * @param products
	 */
	public void setProducts(Product[] products) {
		this.products = products;
	}

	public Tool getTool() {
		return tool;
	}

	/**
	 * Identifies a pay button. Identifies a shopping cart.
	 * 
	 * @param tool
	 */
	public void setTool(Tool tool) {
		this.tool = tool;
	}

	public String getMerchant() {
		return merchant;
	}

	/**
	 * Different types of merchant: -Dineromail account number without the bar
	 * or the last digit. Alphanumeric indentifier for safe operation (provided
	 * by DineroMail). Associated email to the Dineromail account.
	 * 
	 * @param merchant
	 */
	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}

	public Country getCountry() {
		return country;
	}

	/**
	 * Country where the merchant works
	 * 
	 * @param country
	 */
	public void setCountry(Country country) {
		this.country = country;
	}

	public String getSellerName() {
		return sellerName;
	}

	/**
	 * Merchant 's name or inscription desired to appear instead of the email
	 * address.
	 * 
	 * @param sellerName
	 */
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public Language getLanguage() {
		return language;
	}

	/**
	 * Default language of the purchase process in Spanish. Default language of
	 * the purchase process in Portuguese. Default language of the purchase
	 * process in English. (In case of lack of details, the seller 's country 's
	 * language will be used)
	 * 
	 * @param language
	 */
	public void setLanguage(Language language) {
		this.language = language;
	}

	public long getTransactionId() {
		return transactionId;
	}

	/**
	 * Seller 's transaction code. Usfeul to use the consult service IPN2.
	 * 
	 * @param transactionId
	 */
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public String getOkUrl() {
		return okUrl;
	}

	/**
	 * URL to which the buyer is redirected in case of successful transaction.
	 * 
	 * @param okUrl
	 */
	public void setOkUrl(String okUrl) {
		this.okUrl = okUrl;
	}

	public String getErrorUrl() {
		return errorUrl;
	}

	/**
	 * URL to which the buyer is redirected in case of faulty transaction.
	 * 
	 * @param errorUrl
	 */
	public void setErrorUrl(String errorUrl) {
		this.errorUrl = errorUrl;
	}

	public String getPendingUrl() {
		return pendingUrl;
	}

	/**
	 * URL to which the buyer is redirected in case of pending transaction.
	 * 
	 * @param pendingUrl
	 */
	public void setPendingUrl(String pendingUrl) {
		this.pendingUrl = pendingUrl;
	}

	public boolean isUrlRedirectEnabled() {
		return urlRedirectEnabled;
	}

	/**
	 * Allows to redirect automatically to the set url at ok_url, error_url or
	 * pending_url. It requires to use one of these.
	 * 
	 */
	public void setUrlRedirectEnabled(boolean urlRedirectEnabled) {
		this.urlRedirectEnabled = urlRedirectEnabled;
	}

	public BuyerMessage getBuyerMessage() {
		return buyerMessage;
	}

	/**
	 * Allows or prevents the buyer to send a message to the merchant. Default.
	 * 
	 * @param buyerMessage
	 */
	public void setBuyerMessage(BuyerMessage buyerMessage) {
		this.buyerMessage = buyerMessage;
	}

	public ChangeQuantity getChangeQuantity() {
		return changeQuantity;
	}

	/**
	 * Prevents the purchase items quantity from being modified. Allows the
	 * purchase items quantity to be modified.
	 * 
	 * @param changeQuantity
	 */
	public void setChangeQuantity(ChangeQuantity changeQuantity) {
		this.changeQuantity = changeQuantity;
	}

	public ShippingDisplay getDisplayShipping() {
		return displayShipping;
	}

	/**
	 * ShippingDisplay.HIDE: Hides the shipping step. Default.
	 * ShippingDisplay.SHOW: Shows the shipping step. 1 In case of shipping
	 * existence _type_x, the default of display_shipping = 1.
	 * 
	 * @param displayShipping
	 */
	public void setDisplayShipping(ShippingDisplay displayShipping) {
		this.displayShipping = displayShipping;
	}

	public AdditionalChargeDisplay getDisplayAdditionalCharge() {
		return displayAdditionalCharge;
	}

	/**
	 * Hides the additional charges details Default. Shows the additional
	 * charges details “Fixed”. Shows the additional charges details “Variable”.
	 * In case of existence of additional_fixed_charge the default of
	 * 
	 * @param displayAdditionalCharge
	 */
	public void setDisplayAdditionalCharge(
			AdditionalChargeDisplay displayAdditionalCharge) {
		this.displayAdditionalCharge = displayAdditionalCharge;
	}

	public String getBuyerName() {
		return buyerName;
	}

	/**
	 * Buyer 's name
	 * 
	 * @param buyerName
	 */
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerLastName() {
		return buyerLastName;
	}

	/**
	 * Buyer 's last name
	 * 
	 * @param buyerLastName
	 */
	public void setBuyerLastName(String buyerLastName) {
		this.buyerLastName = buyerLastName;
	}

	public Sex getBuyerSex() {
		return buyerSex;
	}

	/**
	 * Buyer 's sex. MALE/FEMALE
	 * 
	 * @param buyerSex
	 */
	public void setBuyerSex(Sex buyerSex) {
		this.buyerSex = buyerSex;
	}

	public BuyerCountry getBuyerNationality() {
		return buyerNationality;
	}

	/**
	 * Buyer 's Nationality
	 * 
	 * @param buyerNationality
	 */
	public void setBuyerNationality(BuyerCountry buyerNationality) {
		this.buyerNationality = buyerNationality;
	}

	public String getBuyerDocumentNumber() {
		return buyerDocumentNumber;
	}

	/**
	 * Buyer 's identificationNumber
	 * 
	 * @param buyerDocumentNumber
	 */
	public void setBuyerDocumentNumber(String buyerDocumentNumber) {
		this.buyerDocumentNumber = buyerDocumentNumber;
	}

	public String getBuyerStreet() {
		return buyerStreet;
	}

	public void setBuyerStreet(String buyerStreet) {
		this.buyerStreet = buyerStreet;
	}

	public DocumentType getBuyerDocumentType() {
		return buyerDocumentType;
	}

	public void setBuyerDocumentType(DocumentType documentType) {
		this.buyerDocumentType = documentType;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	/**
	 * Buyer 's email address
	 * 
	 * @param buyerEmail
	 */
	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}

	public String getBuyerPhone() {
		return buyerPhone;
	}

	/**
	 * Buyer 's telephone number
	 * 
	 * @param buyerPhone
	 */
	public void setBuyerPhone(String buyerPhone) {
		this.buyerPhone = buyerPhone;
	}

	public String getBuyerPhoneExtension() {
		return buyerPhoneExtension;
	}

	/**
	 * Buyer 's extension number
	 * 
	 * @param buyerPhoneExtension
	 */
	public void setBuyerPhoneExtension(String buyerPhoneExtension) {
		this.buyerPhoneExtension = buyerPhoneExtension;
	}

	public String getBuyerZipCode() {
		return buyerZipCode;
	}

	/**
	 * Buyer 's zip code
	 * 
	 * @param buyerZipCode
	 */
	public void setBuyerZipCode(String buyerZipCode) {
		this.buyerZipCode = buyerZipCode;
	}

	public String getBuyerSteet() {
		return buyerStreet;
	}

	/**
	 * Buyer 's shipping street
	 * 
	 * @param buyerSteet
	 */
	public void setBuyerSteet(String buyerSteet) {
		this.buyerStreet = buyerSteet;
	}

	public String getBuyerNumber() {
		return buyerNumber;
	}

	/**
	 * Buyer 's shipping address number.
	 * 
	 * @param buyerNumber
	 */
	public void setBuyerNumber(String buyerNumber) {
		this.buyerNumber = buyerNumber;
	}

	public String getBuyerComplement() {
		return buyerComplement;
	}

	/**
	 * Buyer 's shipping complement.
	 * 
	 * @param buyerComplement
	 */
	public void setBuyerComplement(String buyerComplement) {
		this.buyerComplement = buyerComplement;
	}

	public String getBuyerCity() {
		return buyerCity;
	}

	/**
	 * Buyer 's shipping city.
	 * 
	 * @param buyerCity
	 */
	public void setBuyerCity(String buyerCity) {
		this.buyerCity = buyerCity;
	}

	public String getBuyerState() {
		return buyerState;
	}

	/**
	 * Buyer 's shipping state.
	 * 
	 * @param buyerState
	 */
	public void setBuyerState(String buyerState) {
		this.buyerState = buyerState;
	}

	public BuyerCountry getBuyerCountry() {
		return buyerCountry;
	}

	/**
	 * Buyer 's shipping country.
	 * 
	 * @param buyerName
	 */
	public void setBuyerCountry(BuyerCountry buyerCountry) {
		this.buyerCountry = buyerCountry;
	}

	public float getAdditionalFixedCharge() {
		return additionalFixedCharge;
	}

	/**
	 * Allows the buyer to modify the price of the purchase with a fixed cost.
	 * Allows negative values.
	 * 
	 * @param additionalFixedCharge
	 */
	public void setAdditionalFixedCharge(float additionalFixedCharge) {
		this.additionalFixedCharge = additionalFixedCharge;
	}

	public Currency getAdditionalFixedChargeCurrency() {
		return additionalFixedChargeCurrency;
	}

	/**
	 * Additional cost currency in Argentinian peso. Additional cost currency in
	 * Mexican peso. Additional cost currency in Chilean peso. Additional cost
	 * currency in American dollar. Additional cost currency in Brazilian real.
	 * (If the information is not entered, the merchant 's currency will be
	 * adopted).
	 * 
	 * @param additionalFixedChargeCurrency
	 */
	public void setAdditionalFixedChargeCurrency(
			Currency additionalFixedChargeCurrency) {
		this.additionalFixedChargeCurrency = additionalFixedChargeCurrency;
	}

	public float getAdditionalVariableCharge() {
		return additionalVariableCharge;
	}

	/**
	 * Allows the buyer to modify the price of the purchase with a percentage of
	 * it.
	 * 
	 * @param additionalVariableCharge
	 */
	public void setAdditionalVariableCharge(float additionalVariableCharge) {
		this.additionalVariableCharge = additionalVariableCharge;
	}

	public String getHeaderImage() {
		return headerImage;
	}

	/**
	 * URL of the image shown in the header. The maximal size of the left side
	 * logo is 200x100 pi'xels and 760x100 pi'xels in JPG o GIF format for the
	 * complete header. We recommend to host the image in a safe server (https)
	 * or to send the image to Dineromail to be hosted there.
	 * 
	 * @param headerImage
	 */
	public void setHeaderImage(String headerImage) {
		this.headerImage = headerImage;
	}

	public HeaderWidth getHeaderWidth() {
		return headerWidth;
	}

	/**
	 * Indicates that the image only occupies the top left corner of header.
	 * Default. Indicates that de image occupies the whole header.
	 * 
	 * @param headerWidth
	 */
	public void setHeaderWidth(HeaderWidth headerWidth) {
		this.headerWidth = headerWidth;
	}

	public ExpandedStepPM getExpandedStepPM() {
		return expandedStepPM;
	}

	/**
	 * Shows the step of payment methods folded. Default. 1 Shows the step of
	 * payment methods unfolded.
	 * 
	 * @param expandedStepPM
	 */
	public void setExpandedStepPM(ExpandedStepPM expandedStepPM) {
		this.expandedStepPM = expandedStepPM;
	}

	public ExpandedStepAD getExpandedStepAD() {
		return expandedStepAD;
	}

	/**
	 * Shows the step of payment methods folded. Default. 1 Shows the step of
	 * payment methods unfolded.
	 * 
	 * @param expandedStepAD
	 */
	public void setExpandedStepAD(ExpandedStepAD expandedStepAD) {
		this.expandedStepAD = expandedStepAD;
	}

	public ExpandedStepSC getExpandedStepSC() {
		return expandedStepSC;
	}

	/**
	 * 1 Shows the shipping detail unfolded. Shows the shipping detail folded.
	 * Default.
	 */
	public void setExpandedStepSC(ExpandedStepSC expandedStepSC) {
		this.expandedStepSC = expandedStepSC;
	}

	public ExpandedSaleDetail getExpandedSaleDetail() {
		return expandedSaleDetail;
	}

	/**
	 * Shows the sale detail folded. Shows the sale detail unfolded. Default.
	 */
	public void setExpandedSaleDetail(ExpandedSaleDetail expandedSaleDetail) {
		this.expandedSaleDetail = expandedSaleDetail;
	}

	public String getStepColor() {
		return stepColor;
	}

	/**
	 * Background color of inactive steps and detail title background.
	 * 
	 * @param stepColor
	 */
	public void setStepColor(String stepColor) {
		this.stepColor = stepColor;
	}

	public String getHoverStepColor() {
		return hoverStepColor;
	}

	/**
	 * Background color of active step (in hover state).
	 * 
	 * @param hoverStepColor
	 */
	public void setHoverStepColor(String hoverStepColor) {
		this.hoverStepColor = hoverStepColor;
	}

	public String getLinksColor() {
		return linksColor;
	}

	/**
	 * Links, total, subtotal of discounts and tittles arrows color.
	 * 
	 * @param linksColor
	 */
	public void setLinksColor(String linksColor) {
		this.linksColor = linksColor;
	}

	public String getFontColor() {
		return fontColor;
	}

	/**
	 * Page font color.
	 * 
	 * @param fontColor
	 */
	public void setFontColor(String fontColor) {
		this.fontColor = fontColor;
	}

	public String getBorderColor() {
		return borderColor;
	}

	/**
	 * Buttons and tables color.
	 * 
	 * @param borderColor
	 */
	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}

	public String getButtonColor() {
		return buttonColor;
	}

	/**
	 * Button background color.
	 * 
	 * @param hoverStepColor
	 */
	public void setButtonColor(String buttonColor) {
		this.buttonColor = buttonColor;
	}

	public String getButtonImage() {
		return buttonImage;
	}

	/**
	 * You can choose the payment button image by indicating de Url where it is
	 * located.
	 * 
	 * @param hoverStepColor
	 */
	public void setButtonImage(String buttonImage) {
		this.buttonImage = buttonImage;
	}

	public boolean isHeaderVisible() {
		return headerVisible;
	}

	/**
	 * You can hide the header through the whole transaction process
	 * 
	 * @param hoverStepColor
	 */
	public void setHeaderVisible(boolean headerVisible) {
		this.headerVisible = headerVisible;
	}

	public boolean isSummaryVisible() {
		return summaryVisible;
	}

	/**
	 * You can hide the transaction details (items, additional charges, price)
	 * through all the process
	 * 
	 * @param hoverStepColor
	 */
	public void setSummaryVisible(boolean summaryVisible) {
		this.summaryVisible = summaryVisible;
	}

	/**
	 * 
	 * @return
	 */
	public boolean validateMandatoryFields() {
		if (StringUtils.isEmptyString(merchant)) {
			return false;
		}

		if (country == null) {
			return false;
		}

		for (int j = 0; j < products.length; j++) {
			Product product = products[j];
			if (!product.isValid()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @return
	 */
	public String getParams() {
		String params = "";

		params += "merchant=" + merchant;
		if (tool != null) {
			params += "&tool=" + tool.getValue();
		}
		params += "&country_id=" + String.valueOf(country.getValue());
		if (!StringUtils.isEmptyString(sellerName)) {
			params += "&seller_name=" + sellerName;
		}
		if (language != null) {
			params += "&language=" + language.getValue();
		}
		if (transactionId != 0) {
			params += "&transaction_id=" + String.valueOf(transactionId);
		}

		params += "&currency=" + getCurrencyAsString();

		if (!StringUtils.isEmptyString(okUrl)) {
			params += "&ok_url=" + okUrl;
		}
		if (!StringUtils.isEmptyString(errorUrl)) {
			params += "&error_url=" + errorUrl;
		}
		if (!StringUtils.isEmptyString(pendingUrl)) {
			params += "&pending_url=" + pendingUrl;
		}
		if (buyerMessage != null) {
			params += "&buyer_message="
					+ String.valueOf(buyerMessage.getValue());
		}
		if (changeQuantity != null) {
			params += "&change_quantity="
					+ String.valueOf(changeQuantity.getValue());
		}
		if (displayShipping != null) {
			params += "&display_shipping="
					+ String.valueOf(displayShipping.getValue());
		}
		if (displayAdditionalCharge != null) {
			params += "&display_additional_charge="
					+ String.valueOf(displayAdditionalCharge.getValue());
		}

		if (!StringUtils.isEmptyString(getPaymentMethodsAsString())) {
			params += "&payment_method_available="
					+ getPaymentMethodsAsString();
		}
		if (!StringUtils.isEmptyString(getPaymentMethodDefaultAsString())) {
			params += "&payment_method_1=" + getPaymentMethodDefaultAsString();
		}
		// ITEMS
		int i = 1;
		for (int j = 0; j < products.length; j++) {

			Product product = products[j];
			params += "&item_name_" + i + "=" + product.getName();
			if (!StringUtils.isEmptyString(product.getCode())) {
				params += "&item_code_" + i + "=" + product.getCode();
			}
			params += "&item_quantity_" + i + "="
					+ String.valueOf(product.getQuantity());
			params += "&item_ammount_" + i + "="
					+ StringUtils.doubleToString(product.getAmount());
			if (product.getCurrency() != null) {
				params += "&item_currency_" + i + "="
						+ product.getCurrency().getValue();
			}
			if (product.getShippingType() != null) {
				params += "&shipping_type_" + i + "="
						+ String.valueOf(product.getShippingType().getValue());
			}
			if (product.getWeight() != null) {
				params += "&weight_" + i + "=" + product.getWeight().getValue();
			}
			if (product.getWeightValue() != 0) {
				params += "&item_weight_" + i + "="
						+ StringUtils.doubleToString(product.getWeightValue());
			}

			if (product.getShippingCurrency() != null) {
				params += "&shipping_currency_" + i + "="
						+ product.getShippingCurrency().getValue();
			}
			if (product.getShippingCostDefault() != 0) {
				params += "&shipping_cost_1_"
						+ i
						+ "="
						+ StringUtils.doubleToString(product
								.getShippingCostDefault());
			}

			if (product.getShippingCostTwo() != 0) {
				params += "&shipping_cost_2_"
						+ i
						+ "="
						+ StringUtils.doubleToString(product
								.getShippingCostTwo());
			}

			if (!StringUtils.isEmptyString(product
					.getAdditionalVarDescription())) {
				params += "&additional_var_description_" + i + "="
						+ product.getAdditionalVarDescription();
			}
			if (!StringUtils.isEmptyString(product.getAdditionalVarValue())) {
				params += "&additional_var_value_" + i + "="
						+ product.getAdditionalVarValue();
			}

			if (product.getAdditionalVarVisible() != null) {
				params += "&additional_var_visible_"
						+ i
						+ "="
						+ String.valueOf(product.getAdditionalVarVisible()
								.getValue());
			}
			if (product.isAdditionalVarRequired() != null) {
				params += "&additional_var_required_"
						+ i
						+ "="
						+ String.valueOf(product.isAdditionalVarRequired()
								.booleanValue() ? "1" : "0");
			}
			i++;
		}

		// BUYER
		if (!StringUtils.isEmptyString(buyerName)) {
			params += "&buyer_name=" + buyerName;
		}
		if (!StringUtils.isEmptyString(buyerLastName)) {
			params += "&buyer_lastname=" + buyerLastName;
		}
		if (buyerSex != null) {
			params += "&buyer_sex=" + buyerSex.getValue();
		}
		if (buyerNationality != null) {
			params += "&buyer_nacionality=" + buyerNationality.getValue();
		}

		if (buyerDocumentType != null) {
			params += "&buyer_document_type=" + buyerDocumentType.getValue();
		}

		if (!StringUtils.isEmptyString(buyerDocumentNumber)) {
			params += "&buyer_document_number=" + buyerDocumentNumber;
		}
		if (!StringUtils.isEmptyString(buyerEmail)) {
			params += "&buyer_email=" + buyerEmail;
		}
		if (!StringUtils.isEmptyString(buyerPhone)) {
			params += "&buyer_phone=" + buyerPhone;
		}
		if (!StringUtils.isEmptyString(buyerPhoneExtension)) {
			params += "&buyer_phone_extension=" + buyerPhoneExtension;
		}
		if (!StringUtils.isEmptyString(buyerZipCode)) {
			params += "&buyer_zip_code=" + buyerZipCode;
		}
		if (!StringUtils.isEmptyString(buyerStreet)) {
			params += "&buyer_street=" + buyerStreet;
		}
		if (!StringUtils.isEmptyString(buyerNumber)) {
			params += "&buyer_number=" + buyerNumber;
		}
		if (!StringUtils.isEmptyString(buyerComplement)) {
			params += "&buyer_complement=" + buyerComplement;
		}
		if (!StringUtils.isEmptyString(buyerCity)) {
			params += "&buyer_city=" + buyerCity;
		}
		if (!StringUtils.isEmptyString(buyerState)) {
			params += "&buyer_state=" + buyerState;
		}
		if (buyerCountry != null) {
			params += "&buyer_country=" + buyerCountry.getValue();
		}

		// ADITIONAL VARIABLES
		if (additionalFixedCharge != 0) {
			params += "&additional_fixed_charge="
					+ StringUtils.doubleToString(additionalFixedCharge);
		}

		if (additionalVariableCharge != 0) {
			params += "&additional_variable_charge="
					+ StringUtils.doubleToString(additionalVariableCharge);
		}

		if (additionalFixedChargeCurrency != null) {
			params += "&additional_fixed_charge_currency="
					+ additionalFixedChargeCurrency.getValue();
		}

		// DESIGN VARIABLES
		if (!StringUtils.isEmptyString(headerImage)) {
			params += "&header_image=" + headerImage;
		}
		if (headerWidth != null) {
			params += "&header_width=" + String.valueOf(headerWidth.getValue());
		}
		if (expandedStepPM != null) {
			params += "&expanded_step_PM="
					+ String.valueOf(expandedStepPM.getValue());
		}
		if (expandedStepAD != null) {
			params += "&expanded_step_AD="
					+ String.valueOf(expandedStepAD.getValue());
		}
		if (expandedStepSC != null) {
			params += "&expanded_step_SC="
					+ String.valueOf(expandedStepSC.getValue());
		}
		if (expandedSaleDetail != null) {
			params += "&expanded_sale_detail="
					+ String.valueOf(expandedSaleDetail.getValue());
		}
		if (!StringUtils.isEmptyString(stepColor)) {
			params += "&step_color=" + stepColor;
		}
		if (!StringUtils.isEmptyString(hoverStepColor)) {
			params += "&hover_step_color=" + hoverStepColor;
		}
		if (!StringUtils.isEmptyString(linksColor)) {
			params += "&links_color=" + linksColor;
		}
		if (!StringUtils.isEmptyString(fontColor)) {
			params += "&font_color=" + fontColor;
		}
		if (!StringUtils.isEmptyString(borderColor)) {
			params += "&border_color=" + borderColor;
		}
		if (!StringUtils.isEmptyString(buttonColor)) {
			params += "&button_color=" + buttonColor;
		}

		return params;
	}

	public String checkout() {
		String params = getParams();
		return params;
	}

	public abstract String getPaymentMethodsAsString();

	public abstract String getPaymentMethodDefaultAsString();

	public abstract String getCurrencyAsString();
}
