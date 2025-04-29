package com.koda.interview_test.model.dto;

public class CoindeskNewBpiGbpDTO {

	private String currencyCode;
	
	private String currencyCodeZh;

	private String rate;

	public CoindeskNewBpiGbpDTO() {
		super();
	}

	public CoindeskNewBpiGbpDTO(String currencyCode, String currencyCodeZh, String rate) {
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

	@Override
	public String toString() {
		return "CoindeskNewBpiGbpDTO [currencyCode=" + currencyCode + ", currencyCodeZh=" + currencyCodeZh + ", rate="
				+ rate + "]";
	}
}
