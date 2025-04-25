package com.koda.interview_test.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrencyInfoVO {

	@JsonProperty(value = "currency_code")
	private String currencyCode;

	@JsonProperty(value = "currency_name_zh")
	private String currencyNameZh;

	@JsonProperty(value = "currency_name_en")
	private String currencyNameEn;

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

	public String getCurrencyNameEn() {
		return currencyNameEn;
	}

	public void setCurrencyNameEn(String currencyNameEn) {
		this.currencyNameEn = currencyNameEn;
	}
}
