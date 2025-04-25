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
	
	@Column(name = "currency_name_en")
	private String currencyNameEn;

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
