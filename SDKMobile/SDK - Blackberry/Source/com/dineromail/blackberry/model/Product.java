package com.dineromail.blackberry.model;

 
import com.dineromail.blackberry.enums.AdditionalVarDisplay;
import com.dineromail.blackberry.enums.Currency;
import com.dineromail.blackberry.enums.ShippingType;
import com.dineromail.blackberry.enums.Weight;
import com.dineromail.blackberry.utils.StringUtils;

public class Product {

	private String name;
	private String code;
	private int quantity;
	private float amount;
	private Currency currency;

	private Weight weight;
	private float weightValue;

	private float shippingCostDefault;
	private float shippingCostTwo;

	private ShippingType shippingType;
	private Currency shippingCurrency;

	// Additional variables
	private String additionalVarDescription;
	private String additionalVarValue;
	private AdditionalVarDisplay additionalVarVisible;
	private Boolean additionalVarRequired;

	public String getName() {
		return name;
	}

	/**
	 * Name of the item for sale.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	/**
	 * Code of the item for sale.
	 * 
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	public int getQuantity() {
		return quantity;
	}

	/**
	 * Quantity of required items.
	 * 
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getAmount() {
		return amount;
	}

	/**
	 * Name of the item for sale.
	 * 
	 * @param ammount
	 */
	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	/**
	 * Currency of the item for sale in Argentinian peso. Currency of the item
	 * for sale in Mexican peso. Currency of the item for sale in Chilean peso.
	 * Currency of the item for sale in American dollar. Currency of the item
	 * for sale in Brazilian real.
	 * 
	 * @param currency
	 */
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Weight getWeight() {
		return weight;
	}

	/**
	 * Defines the weight unit in KG. Defines the weight unit in Lb. Obligatory
	 * if ShippingType = ShippingType.WEIGHT
	 * 
	 * @param weight
	 */
	public void setWeight(Weight weight) {
		this.weight = weight;
	}

	public float getWeightValue() {
		return weightValue;
	}

	/**
	 * Weight of the item for sale. Obligatory if ShippingType =
	 * ShippingType.WEIGHT
	 * 
	 * @param weightValue
	 */
	public void setWeightValue(float weightValue) {
		this.weightValue = weightValue;
	}

	public float getShippingCostDefault() {
		return shippingCostDefault;
	}

	/**
	 * Shipping cost for 1 quantity. Obligatory if ShippingType =
	 * ShippingType.FIXED_COST or ShippingType.FIXED_QUANTITY_COST
	 * 
	 * @param shippingCostOne
	 */
	public void setShippingCostDefault(float shippingCostOne) {
		this.shippingCostDefault = shippingCostOne;
	}

	public float getShippingCostTwo() {
		return shippingCostTwo;
	}

	/**
	 * Shipping cost of the product for bigger quantities. Obligatory if
	 * ShippingType = ShippingType.FIXED_QUANTITY_COST
	 * 
	 * @param shippingCostTwo
	 */
	public void setShippingCostTwo(float shippingCostTwo) {
		this.shippingCostTwo = shippingCostTwo;
	}

	public ShippingType getShippingType() {
		return shippingType;
	}

	/**
	 * Not available shipping product. Default. Shipping with fixed cost. Always
	 * use the value established on variable shipping_cost_1_x per unit of
	 * item_x.
	 * 
	 * @param shippingType
	 */
	public void setShippingType(ShippingType shippingType) {
		this.shippingType = shippingType;
	}

	public Currency getShippingCurrency() {
		return shippingCurrency;
	}

	/**
	 * Currency of the shipping cost in Argentinian peso. Currency of the
	 * shipping cost in Mexican peso. Currency of the shipping cost in Chilean
	 * peso. Currency of the shipping cost in American dollar. Currency of the
	 * shipping cost in Brazilian real. (If the information is not entered, the
	 * merchant's currency will be adopted.)
	 * 
	 * @param shippingCurrency
	 */
	public void setShippingCurrency(Currency shippingCurrency) {
		this.shippingCurrency = shippingCurrency;
	}

	public String getAdditionalVarDescription() {
		return additionalVarDescription;
	}

	/**
	 * Name of the additional variable.
	 * 
	 * @param additionalVarDescription
	 */
	public void setAdditionalVarDescription(String additionalVarDescription) {
		this.additionalVarDescription = additionalVarDescription;
	}

	public String getAdditionalVarValue() {
		return additionalVarValue;
	}

	/**
	 * Additional variable value (non editable by the buyer). In not entered,
	 * the buyer will be able to edit it.
	 * 
	 * @param additionalVarValue
	 */
	public void setAdditionalVarValue(String additionalVarValue) {
		this.additionalVarValue = additionalVarValue;
	}

	public AdditionalVarDisplay getAdditionalVarVisible() {
		return additionalVarVisible;
	}

	/**
	 * if set to true, Hides additionalVarDescription and additionalVarValue.
	 * 
	 * @param additionalVarVisible
	 */
	public void setAdditionalVarVisible(AdditionalVarDisplay additionalVarVisible) {
		this.additionalVarVisible = additionalVarVisible;
	}

	public Boolean isAdditionalVarRequired() {
		return additionalVarRequired;
	}

	/**
	 * if set to false, the parameter additionalVarValue is not obligatory
	 * 
	 * @param additionalVarRequired
	 */
	public void setAdditionalVarRequired(Boolean additionalVarRequired) {
		this.additionalVarRequired = additionalVarRequired;
	}

 
	public String toString() {
		return name;
	}

 
	public boolean equals(Object o) {
		Product p = (Product) o;
		return this.name.equals(p.getName());
	}

	public boolean isValid() {
		if (StringUtils.isEmptyString(name)) {
			return false;
		}
		if (quantity <= 0) {
			return false;
		}
		if (amount <= 0) {
			return false;
		}
		return true;
	}
}
