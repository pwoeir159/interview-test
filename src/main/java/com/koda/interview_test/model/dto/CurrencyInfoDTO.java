package com.koda.interview_test.model.dto;

public class CurrencyInfoDTO {

	private String currencyCode;

	private String currencyNameZh;

	private String description;

	public CurrencyInfoDTO() {
		super();
	}

	public CurrencyInfoDTO(String currencyCode, String currencyNameZh) {
		super();
		this.currencyCode = currencyCode;
		this.currencyNameZh = currencyNameZh;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
