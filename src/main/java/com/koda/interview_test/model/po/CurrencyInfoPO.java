package com.koda.interview_test.model.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currency_info")
public class CurrencyInfoPO {

	@Id
	@Column(name = "currency_code")
	private String currencyCode;
	
	@Column(name = "currency_name_zh")
	private String currencyNameZh;
	
	@Column(name = "description")
	private String description;

	public CurrencyInfoPO() {
		super();
	}

	public CurrencyInfoPO(String currencyCode, String currencyNameZh, String description) {
		super();
		this.currencyCode = currencyCode;
		this.currencyNameZh = currencyNameZh;
		this.description = description;
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

	@Override
	public String toString() {
		return "CurrencyInfoPO [currencyCode=" + currencyCode + ", currencyNameZh=" + currencyNameZh + ", description="
				+ description + "]";
	}
}
