package com.koda.interview_test.model.dto;

public class CoindeskNewBpiDTO {

	private String currencyCode;
	
	private String currencyCodeZh;

	private String rate;

	public CoindeskNewBpiDTO() {
		super();
	}

	public CoindeskNewBpiDTO(String currencyCode, String currencyCodeZh, String rate) {
		super();
		this.currencyCode = currencyCode;
		this.currencyCodeZh = currencyCodeZh;
		this.rate = rate;
	}

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
}
