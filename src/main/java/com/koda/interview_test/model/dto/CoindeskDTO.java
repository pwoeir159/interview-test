package com.koda.interview_test.model.dto;

import java.time.LocalDateTime;

public class CoindeskDTO {

	private LocalDateTime updated;
	
	private String currencyCode;
	
	private String currencyCodeZh;
	
	private String rate;

	public LocalDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
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
