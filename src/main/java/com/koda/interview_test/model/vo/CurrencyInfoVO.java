package com.koda.interview_test.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrencyInfoVO {

	@JsonProperty(value = "currency_code")
	private String currencyCode;

	@JsonProperty(value = "currency_name_zh")
	private String currencyNameZh;

	@JsonProperty(value = "description")
	private String description;

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCurrencyNameZh() {
		return currencyNameZh;
	}

	public void setCurrencyNameZh(String currencyNameZh) {
		this.currencyNameZh = currencyNameZh;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
