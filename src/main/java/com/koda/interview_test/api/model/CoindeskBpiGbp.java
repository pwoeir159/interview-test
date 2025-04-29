package com.koda.interview_test.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoindeskBpiGbp {

	@JsonProperty(value = "code")
	private String code;
	
	@JsonProperty(value = "symbol")
	private String symbol;
	
	@JsonProperty(value = "rate")
	private String rate;
	
	@JsonProperty(value = "description")
	private String description;
	
	@JsonProperty(value = "rate_float")
	private Double rateFloat;

	public CoindeskBpiGbp() {
		super();
	}

	public CoindeskBpiGbp(String code, String symbol, String rate, String description, Double rateFloat) {
		super();
		this.code = code;
		this.symbol = symbol;
		this.rate = rate;
		this.description = description;
		this.rateFloat = rateFloat;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getRateFloat() {
		return rateFloat;
	}

	public void setRateFloat(Double rateFloat) {
		this.rateFloat = rateFloat;
	}
}
