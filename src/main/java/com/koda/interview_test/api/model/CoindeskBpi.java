package com.koda.interview_test.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoindeskBpi {

	@JsonProperty(value = "USD")
	private CoindeskBpiUsd usd;
	
	@JsonProperty(value = "GBP")
	private CoindeskBpiGbp gbp;
	
	@JsonProperty(value = "EUR")
	private CoindeskBpiEur eur;

	public CoindeskBpiUsd getUsd() {
		return usd;
	}

	public void setUsd(CoindeskBpiUsd usd) {
		this.usd = usd;
	}

	public CoindeskBpiGbp getGbp() {
		return gbp;
	}

	public void setGbp(CoindeskBpiGbp gbp) {
		this.gbp = gbp;
	}

	public CoindeskBpiEur getEur() {
		return eur;
	}

	public void setEur(CoindeskBpiEur eur) {
		this.eur = eur;
	}
}
