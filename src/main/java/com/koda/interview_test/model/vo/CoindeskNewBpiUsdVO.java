package com.koda.interview_test.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoindeskNewBpiUsdVO {

	@JsonProperty(value = "code")
	private String currencyCode;
	
	@JsonProperty(value = "code_zh")
	private String currencyCodeZh;

	@JsonProperty(value = "rate")
	private String rate;

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCurrencyCodeZh() {
		return currencyCodeZh;
	}

	public void setCurrencyCodeZh(String currencyCodeZh) {
		this.currencyCodeZh = currencyCodeZh;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "CoindeskNewBpiUsdDTO [currencyCode=" + currencyCode + ", currencyCodeZh=" + currencyCodeZh + ", rate="
				+ rate + "]";
	}
}
