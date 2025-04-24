package com.koda.interview_test.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coindesk {
	
	@JsonProperty(value = "time")
	private CoindeskTime time;
	
	@JsonProperty(value = "disclaimer")
	private String disclaimer;
	
	@JsonProperty(value = "chartName")
	private String chartName;
	
	@JsonProperty(value = "bpi")
	private CoindeskBpi bpi;

	public CoindeskTime getTime() {
		return time;
	}

	public void setTime(CoindeskTime time) {
		this.time = time;
	}

	public String getDisclaimer() {
		return disclaimer;
	}

	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}

	public String getChartName() {
		return chartName;
	}

	public void setChartName(String chartName) {
		this.chartName = chartName;
	}

	public CoindeskBpi getBpi() {
		return bpi;
	}

	public void setBpi(CoindeskBpi bpi) {
		this.bpi = bpi;
	}


}
