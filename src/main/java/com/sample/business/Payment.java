package com.sample.business;

import org.springframework.data.annotation.Id;

public class Payment {
	@Id
	private String chargId;
	public String getChargId() {
		return chargId;
	}

	public void setChargId(String chargId) {
		this.chargId = chargId;
	}

	private String description;
	private int amount;
	private Currency currency;
	private String userEmail;
	private String stripeToken;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getStripeToken() {
		return stripeToken;
	}

	public void setStripeToken(String stripeToken) {
		this.stripeToken = stripeToken;
	}

	public enum Currency {
		EUR, USD;
	}
}
