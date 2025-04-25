package com.koda.interview_test.model.dto;

public class CurrencyInfoDTO {

	private String currencyCode;

	private String currencyNameZh;

	private String currencyNameEn;

	public CurrencyInfoDTO() {
		super();
	}

	public CurrencyInfoDTO(String currencyCode, String currencyNameZh, String currencyNameEn) {
		super();
		this.currencyCode = currencyCode;
		this.currencyNameZh = currencyNameZh;
		this.currencyNameEn = currencyNameEn;
	}

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
